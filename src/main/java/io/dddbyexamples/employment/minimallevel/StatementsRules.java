package io.dddbyexamples.employment.minimallevel;

import java.util.List;
import java.util.stream.Collectors;

class StatementsRules {

    private List<Statement> existingStatement;
    private Ruleski ruleski;

    private Result result;

    StatementsRules(List<Statement> existingStatement, Ruleski ruleski) {
        this.existingStatement = existingStatement;
        this.ruleski = ruleski;
    }

    Result check(Statement statement) {
        result = new Result();

        checkAmountOfHours(statement);
        checkStatementLevels(statement);
        checkNumberOfStatements(statement);
        checkSameCourseStatement(statement);

        return result;
    }

    private void checkSameCourseStatement(Statement statement) {
        long sameStatementsDefinition = existingStatement.stream().filter(statement::equals).count();

        if (sameStatementsDefinition > 0) {
            //new Ruleska("przekroczona ilośc oswiadczen")
            result.reject(ruleski.courseDuplicate(statement.getCourses()));
        }

    }

    private void checkNumberOfStatements(Statement statement) {
        if (existingStatement.size() >= 2) {
            //new Ruleska("przekroczona ilośc oswiadczen")
            result.reject(ruleski.exceededNumberOfStatements());
        }
    }

    private void checkStatementLevels(Statement statement) {
        List<Statement> secondLevelStatemets = existingStatement
                .stream()
                .filter(s -> s.calculateLevel().isSecondLevel())
                .collect(Collectors.toList());

        if (statement.calculateLevel().isSecondLevel()) {
            secondLevelStatemets.add(statement);
        }

        if (secondLevelStatemets.size() > 1) {
            //new Ruleska("przekroczona ilośc oswiadczen")
            result.reject(ruleski.exceededNumberOfStatements());
        }

    }

    private void checkAmountOfHours(Statement statement) {
        if (statement.getHours() < 30) {
            //new Ruleska("za mala ilosc godzin w oswiadczeniu")
            result.reject(ruleski.notEnoughtDeclaredHouers(statement.getHours()));
        }
    }
}
