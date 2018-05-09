package io.dddbyexamples.employment.minimallevel;

import lombok.Value;

/**
 * Created by tfert on 09.05.18.
 */
@Value
public class StatementLevel {
    private int level;



    public boolean isSecondLevel() {
        return level == 2;
    }
}
