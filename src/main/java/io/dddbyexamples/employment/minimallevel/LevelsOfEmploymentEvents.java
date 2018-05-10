package io.dddbyexamples.employment.minimallevel;

public interface LevelsOfEmploymentEvents {
    void emit(StatementSubmitted event);
    void emit(StatementSuspended event);
}
