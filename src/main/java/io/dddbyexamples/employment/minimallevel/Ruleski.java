package io.dddbyexamples.employment.minimallevel;

import io.dddbyexamples.rules.RuleId;
import io.dddbyexamples.rules.Ruleska;

import java.util.List;

public interface Ruleski {

    @RuleId("R_1728")
    Ruleska exceededNumberOfStatements();

    @RuleId("R_1724")
    Ruleska notEnoughtDeclaredHouers(int hours);

    @RuleId("R_1730")
    Ruleska courseDuplicate(List<Course> courses);
}
