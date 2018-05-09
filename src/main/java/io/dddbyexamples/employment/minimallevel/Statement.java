package io.dddbyexamples.employment.minimallevel;


import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
class Statement {

    private List<Course> courses;
    private int hours;

    public StatementLevel calculateLevel() {
        int calculatedLevel = courses.stream()
                .mapToInt(Course::getLevel)
                .max()
                .orElse(0);

        return new StatementLevel(calculatedLevel);
    }
}
