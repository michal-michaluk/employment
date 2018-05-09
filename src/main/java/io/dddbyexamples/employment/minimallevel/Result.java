package io.dddbyexamples.employment.minimallevel;

import io.dddbyexamples.rules.Ruleska;

import java.util.Collections;
import java.util.List;

class Result {

    boolean isAccepted() {
        return true;
    }

    boolean isSuspended() {
        return false;
    }

    List<Ruleska> getProblems() {
        return Collections.emptyList();
    }
}
