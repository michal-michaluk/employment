package io.dddbyexamples.employment.minimallevel;

import io.dddbyexamples.rules.Ruleska;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    private List<Ruleska> errors = new ArrayList<>();
    private boolean accepted = true;
    private boolean suspended = false;

    Result() {
    }

    private Result(boolean accepted, boolean suspended, List<Ruleska> errors) {
        this.accepted = accepted;
        this.suspended = suspended;
        this.errors = errors;
    }

    boolean isAccepted() {
        return accepted;
    }

    boolean isSuspended() {
        return suspended;
    }

    void reject(Ruleska reason) {
        accepted = false;
        errors.add(reason);
    }

    void suspend(Ruleska reason) {
        suspended = true;
        errors.add(reason);
    }

    List<Ruleska> getProblems() {
        return Collections.unmodifiableList(errors);
    }

    static Result combine(Result... partial) {
        boolean accepted = Stream.of(partial).allMatch(Result::isAccepted);
        boolean suspended = Stream.of(partial).anyMatch(Result::isSuspended);
        List<Ruleska> problems = Stream.of(partial)
                .flatMap(p -> p.getProblems().stream())
                .collect(Collectors.toList());

        return new Result(accepted, suspended, problems);
    }
}
