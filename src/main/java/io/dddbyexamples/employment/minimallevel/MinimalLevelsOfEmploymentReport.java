package io.dddbyexamples.employment.minimallevel;

import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimalLevelsOfEmploymentReport {

    private Long institutionId;
    private PersonPort personRepo;
    private CourseInInstitutionPort courseInInstitution;
    private Map<Long, SusannaReportEntry> reportEntries = new HashMap<>();


    public void onStatementSubmitted(StatementSubmitted event) {
        event.getCourses()
                .stream()
                .filter(course -> isCourseFromInstitution(institutionId, course.getId()))
                .forEach(course -> {
            SusannaReportEntry susannaReportEntry = reportEntries.computeIfAbsent(course.getId(), (courseId) -> new SusannaReportEntry(course.getId(), course.getName()));

            SimplePersonData simplePersonData = translateEmployeeIdToPerson(event.getEmployeeId());
            susannaReportEntry.getCorrectStatements().add(simplePersonData);
        });
    }

    public void onStatementSuspended(StatementSuspended event) {
        event.getCourses()
                .stream()
                .filter(course -> isCourseFromInstitution(institutionId, course.getId()))
                .forEach(course -> {
            SusannaReportEntry susannaReportEntry = reportEntries.get(course.getId());

            if (susannaReportEntry != null) {
                SimplePersonData simplePersonData = translateEmployeeIdToPerson(event.getEmployeeId());

                susannaReportEntry.getCorrectStatements().remove(simplePersonData);
                susannaReportEntry.getSuspendedStatements().add(simplePersonData);
            } else {
                throw new RuntimeException("Niespojny stan obiektu");
            }
        });
    }

    private SimplePersonData translateEmployeeIdToPerson(Long employeeId) {
        SimplePersonData result = personRepo.getPersonByEmployeeId(employeeId);

        return result;
    }

    private boolean isCourseFromInstitution(Long institutionId, long courseId) {
        List<Long> courseIds = courseInInstitution.getActiveCoursesInInstitution(institutionId);

        return courseIds.contains(courseId);
    }


    @Value
    private static class SusannaReportEntry {
        private Long courseId;
        private String courseName;

        private List<SimplePersonData> correctStatements = new ArrayList<>();
        private List<SimplePersonData> suspendedStatements = new ArrayList<>();
        private List<SimplePersonData> closedStatements = new ArrayList<>();
    }
}
