package io.dddbyexamples.employment.minimallevel;

import io.dddbyexamples.shared.AcademicYear;

public interface StatementsRepository {
    SomethingWithStatements get(long employeeId, AcademicYear academicYear);

    void apply(StatementSubmitted event);
}
