package io.dddbyexamples.employment.minimallevel;

import io.dddbyexamples.shared.AcademicYear;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class SomethingWithStatements {

    private long employeeId;
    private AcademicYear academicYear;

    private EmploymentRules employmentRules;
    private CourseOfStudiesRules courseOfStudiesRules;
    private StatementsRules statementsRules;

    private LevelsOfEmploymentEvents events;

    Result submitStatement(Statement statement) {

        Result result = Result.combine(
                statementsRules.check(statement),
                employmentRules.check(statement),
                courseOfStudiesRules.check(statement)
        );

        if (result.isAccepted()) {
            events.emit(translateToEvent(statement));

            if (result.isSuspended()) {
                events.emit(translateSuspendedStatement(statement));
            }
        }
        return result;
    }

    private StatementSuspended translateSuspendedStatement(Statement statement) {
        return new StatementSuspended(statement.getEmployeeId(), statement.getCourses());
    }

    private StatementSubmitted translateToEvent(Statement statement) {
        return new StatementSubmitted(statement.getEmployeeId(), statement.getCourses(), statement.getHours());
    }
}
