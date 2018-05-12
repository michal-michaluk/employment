package io.dddbyexamples.employment.minimallevel;


import lombok.Value;

import java.util.List;

@Value
public class StatementSuspended {

    private Long employeeId;
    private List<Course> courses;
}
