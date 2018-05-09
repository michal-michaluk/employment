package io.dddbyexamples.employment.minimallevel;

import io.dddbyexamples.rules.Ruleska;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Result {

    private List<Ruleska> errors = new ArrayList<>();

    boolean isAccepted() {
        return true;
    }

    boolean isSuspended() {
        return false;
    }

    List<Ruleska> getProblems() {
        return Collections.unmodifiableList(errors);
    }

    public void addError(Ruleska rule) {
        errors.add(rule);
    }
}
