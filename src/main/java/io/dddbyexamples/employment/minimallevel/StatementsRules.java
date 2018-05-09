package io.dddbyexamples.employment.minimallevel;

import io.dddbyexamples.rules.Ruleska;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class StatementsRules {

    private Result result = new Result();
    private List<Statement> existingStatement = new ArrayList<>();

    public Result check(Statement statement) {
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
            result.addError(new Ruleska("przekroczona ilośc oswiadczen"));
        }

    }

    private void checkNumberOfStatements(Statement statement) {
        if (existingStatement.size() >= 2) {
            result.addError(new Ruleska("przekroczona ilośc oswiadczen"));
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
            result.addError(new Ruleska("przekroczona ilośc oswiadczen"));
        }

    }

    private void checkAmountOfHours(Statement statement) {
        if (statement.getHours() < 30) {
            result.addError(new Ruleska("za mala ilosc godzin w oswiadczeniu"));
        }
    }

    public void addExistingStatement(Statement statement) {
        existingStatement.add(statement);
    }
}
