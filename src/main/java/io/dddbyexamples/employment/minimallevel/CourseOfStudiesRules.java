package io.dddbyexamples.employment.minimallevel;

import java.util.List;
import java.util.stream.Collectors;

class CourseOfStudiesRules {
    private final CourseOfStudiesPort courseOfStudies;
    private final Ruleski ruleski;

    private Result result;


    public CourseOfStudiesRules(CourseOfStudiesPort courseOfStudies, Ruleski ruleski) {
        this.courseOfStudies = courseOfStudies;
        this.ruleski = ruleski;
    }



    Result check(Statement statement) {

        isCourseRunning(statement);







        return new Result();
    }

    private void isCourseRunning(Statement statement) {


        List<Long> courseIds = statement.getCourses().stream().map(c -> c.getId()).collect(Collectors.toList());

//        courseOfStudies.

//        courseOfStudies.

    }
}
