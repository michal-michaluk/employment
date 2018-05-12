package io.dddbyexamples.employment.minimallevel;

import java.util.List;

/**
 * Created by tfert on 10.05.18.
 */
public interface CourseInInstitutionPort {
    List<Long> getActiveCoursesInInstitution(Long institutionId);
}
