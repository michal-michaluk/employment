package io.dddbyexamples.infra;

import io.dddbyexamples.employment.minimallevel.LevelsOfEmploymentEvents;
import io.dddbyexamples.employment.minimallevel.MinimalLevelsOfEmploymentReport;
import io.dddbyexamples.employment.minimallevel.StatementSubmitted;
import io.dddbyexamples.employment.minimallevel.StatementSuspended;

class LevelsOfEmploymentEventsPropagation implements LevelsOfEmploymentEvents {

    // Database database;
    // Kafka kafka;
    MinimalLevelsOfEmploymentReport readmodel;

    @Override
    public void emit(StatementSubmitted event) {
        // database.save(event);

        readmodel.onStatementSubmitted(event);

        // kafka.addAndSendAfterTransaction(event);
    }

    @Override
    public void emit(StatementSuspended event) {

    }
}
