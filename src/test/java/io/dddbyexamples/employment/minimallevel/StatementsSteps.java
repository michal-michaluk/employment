package io.dddbyexamples.employment.minimallevel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.dddbyexamples.rules.Ruleska;
import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementsSteps {

    private static final int DEFAULT_HOURS_IN_STATEMENT = 30;

    private Map<String, CourseOfStudyDefinition> courses = new HashMap<>();
    private List<Statement> statements = new ArrayList<>();

    private StatementsRules subject = new StatementsRules(
            statements,
            FakeRuleski.mockRulesAdapter()
    );

    private Result result;

    @Given("^istnieją studia:$")
    public void istniejąStudia(List<CourseOfStudyDefinition> courseOfStudies) throws Throwable {
        courses.putAll(courseOfStudies.stream()
                .collect(Collectors.toMap(
                        CourseOfStudyDefinition::getName,
                        Function.identity())
                ));
    }

    @Given("^istnieje prawidłowe zatrudnienie umożliwiające dodanie oświadczenia o minimum kadrowym$")
    public void istniejePrawidłoweZatrudnienieUmożliwiająceDodanieOświadczeniaOMinimumKadrowym() throws Throwable {
        //todo: zaimplementować
    }

    @Given("^nie ma oświadczeń na dany rok akademicki$")
    public void nieMaOświadczeńNaDanyRokAkademicki() throws Throwable {
        statements.clear();
    }

    @Given("^istniejace oswiadczenie \"([^\"]*)\"$")
    public void istniejaceOswiadczenieWspólne(List<String> courseOfStudies) throws Throwable {
        List<Course> statementCourses = translateCourses(courseOfStudies);
        Statement statement = new Statement(statementCourses, DEFAULT_HOURS_IN_STATEMENT);
        statements.add(statement);
    }

    @When("^wprowadz oswiadczenie \"([^\"]*)\" z liczbą godzin \"([^\"]*)\"$")
    public void wprowadzOswiadczenieZLiczbąGodzin(List<String> courseOfStudy, Integer hoursAmount) throws Throwable {
        Statement statement = new Statement(translateCourses(courseOfStudy), hoursAmount);
        result = subject.check(statement);
    }

    @Then("^oswiadczenie zostanie złożone$")
    public void oswiadczenieZostanieZłożone() throws Throwable {
        assertThat(result)
                .isNotNull()
                .extracting(Result::isAccepted)
                .contains(true);

        assertThat(result.getProblems())
                .isEmpty();
    }

    @Then("^oswiadczenie nie zostanie przyjęte z komunikatem \"([^\"]*)\"$")
    public void oswiadczenieNieZostaniePrzyjęteZKomunikatem(String info) throws Throwable {
        assertThat(result)
                .isNotNull()
                .extracting(Result::isAccepted)
                .contains(false);

        assertThat(result.getProblems())
                .extracting(Ruleska::getRuleId)
                .contains(info);
    }

    private List<Course> translateCourses(List<String> courseOfStudies) {
        return courseOfStudies
                .stream()
                .map(name -> courses.get(name))
                .map(CourseOfStudyDefinition::createCurse)
                .collect(Collectors.toList());
    }

    @Value
    public static class CourseOfStudyDefinition {
        String name;
        String courseOfStudy;
        CourseProfile profile;
        int level;

        Course createCurse() {
            return new Course(name, courseOfStudy, profile, level);
        }
    }
}
