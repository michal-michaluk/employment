package io.dddbyexamples.employment.minimallevel;

import io.dddbyexamples.shared.AcademicYear;
import lombok.AllArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wfred on 10.05.18.
 */
@AllArgsConstructor
public class StatementRepositoryImpl implements StatementsRepository {

    private Ruleski ruleski;
    private Connection connection;
    private CourseOfStudiesPort courseOfStudies;
//    private EmploymentPort employment;
    private LevelsOfEmploymentEvents events;

    @Override
    public SomethingWithStatements get(long employeeId, AcademicYear academicYear) {
        EmploymentRules employmentRules = createEmploymentRules();
        StatementsRules statementRules = createStatementRules(employeeId, academicYear);
        CourseOfStudiesRules courseOfStudiesRules = createCourseOfStudiesRules();

        return new SomethingWithStatements(employeeId, academicYear, employmentRules, courseOfStudiesRules, statementRules, events);
    }


    private StatementsRules createStatementRules(long employeeId, AcademicYear academicYear) {
        List<Statement> existingStatement = createExistingStatements(employeeId, academicYear);
        return new StatementsRules(existingStatement, ruleski);
    }

    private List<Statement> createExistingStatements(long employeeId, AcademicYear academicYear) {
        List<Statement> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * FROM * where employeeId = {1}  AND academicYear = {2}");
                    preparedStatement.setLong(1, employeeId);
                    preparedStatement.setLong(2, academicYear.getBeginYear());

            ResultSet resultSet = preparedStatement.executeQuery();

            result = translateQuery(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private List<Statement> translateQuery(ResultSet resultSet) {
        return new ArrayList<>();
    }

    private EmploymentRules createEmploymentRules() {
        return new EmploymentRules();
    }

    private CourseOfStudiesRules createCourseOfStudiesRules() {
        CourseOfStudiesRules courseOfStudiesRules = new CourseOfStudiesRules(courseOfStudies, ruleski);

        return courseOfStudiesRules;
    }


    @Override
    public void apply(StatementSubmitted event) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into PRN_MIN_CADRE (hours, course) values ({1}, {2})");
            preparedStatement.setInt(1, event.getHours());
            // todo: dokonczyc inserty courow
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
