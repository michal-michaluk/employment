package io.dddbyexamples.employment.minimallevel;

import lombok.Value;

import java.util.List;


@Value
public class StatementSubmitted {

    private Long employeeId;
    private List<Course> courses;
    private int hours;
}
