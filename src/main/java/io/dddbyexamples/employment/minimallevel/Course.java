package io.dddbyexamples.employment.minimallevel;

import lombok.Value;

/**
 * Created by tfert on 09.05.18.
 */
@Value
public class Course {
    private String name;
    private String courseOfStudy;
    private CourseProfile profile;
    private int level;
}
