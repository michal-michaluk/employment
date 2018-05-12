package io.dddbyexamples.employment.minimallevel;

/**
 * Created by tfert on 10.05.18.
 */
public interface PersonPort {


    SimplePersonData getPersonByEmployeeId(Long employeeId);
}
