package io.dddbyexamples.employment.minimallevel;

public class SomethingWithStatements {

    private EmploymentRules employmentRules;
    private CoursOfStudiesRules coursOfStudiesRules;
    private StatementsRules statementsRules;
//
//    private StatementsRepository repository;
//    private Events events;
//
//    public Result submitStatement(SubmitEmployeeMinimulLevelOfEmploymentStatement command) {
//
//        Result statementRulesResult = statementsRules.check(command);
//        Result employmentRulesResult = employmentRules.check(command);
//        Result coursOfStudiesRulesResult = coursOfStudiesRules.check(command);
//
//        if (statementRulesResult.and(employmentRulesResult.and(coursOfStudiesRulesResult).isCorrect())) {
//            repository.save(command.getStatement());
//            events.emit(new StatementSubmited());
//
//            if (statementRulesResult.and(employmentRulesResult.and(coursOfStudiesRulesResult).isSuspended())) {
//                events.emit(new StatementSuspended());
//            }
//        }
//    }
}
