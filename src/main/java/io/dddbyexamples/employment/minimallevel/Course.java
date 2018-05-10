package io.dddbyexamples.employment.minimallevel;

import lombok.Value;

/**
 * Created by wfred on 09.05.18.
 */
@Value
public class Course {
    private long id;
    private String name;
    private String courseOfStudy;
    private CourseProfile profile;
    private int level;
}
