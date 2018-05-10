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

    Result submitStatement(Statement command) {
        Result result = Result.combine(
                statementsRules.check(command),
                employmentRules.check(command),
                courseOfStudiesRules.check(command)
        );

        if (result.isAccepted()) {
            events.emit(new StatementSubmitted());

            if (result.isSuspended()) {
                events.emit(new StatementSuspended());
            }
        }
        return result;
    }
}
