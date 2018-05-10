package io.dddbyexamples.employment.minimallevel;

import lombok.AllArgsConstructor;

/**
 * Created by wfred on 10.05.18.
 */
@AllArgsConstructor
public class LevelsOfEmploymentEventsImpl implements LevelsOfEmploymentEvents {

    private StatementsRepository statementsRepository;

    @Override
    public void emit(StatementSubmitted event) {
        statementsRepository.apply(event);
    }

    @Override
    public void emit(StatementSuspended event) {
        //todo: dokonczyc
    }
}
