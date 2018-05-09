package io.dddbyexamples.employment.minimallevel;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.dddbyexamples.rules.Ruleska;
import lombok.Value;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementsSteps {

    StatementsRules subject;
    private Result result;

    @Given("^istnieją studia:$")
    public void istniejąStudia(List<CourseOfStudyDefinition> courseOfStudies) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^istnieje prawidłowe zatrudnienie umożliwiające dodanie oświadczenia o minimum kadrowym$")
    public void istniejePrawidłoweZatrudnienieUmożliwiająceDodanieOświadczeniaOMinimumKadrowym() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^nie ma oświadczeń na dany rok akademicki$")
    public void nieMaOświadczeńNaDanyRokAkademicki() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^istniejace oswiadczenie wspólne \"([^\"]*)\"$")
    public void istniejaceOswiadczenieWspólne(List<String> courseOfStudies) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^istniejace oswiadczenie \"([^\"]*)\"$")
    public void istniejaceOswiadczenie(String courseOfStudy) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^wprowadz oswiadczenie \"([^\"]*)\" z liczbą godzin \"([^\"]*)\"$")
    public void wprowadzOswiadczenieZLiczbąGodzin(String courseOfStudy, String hoursAmount) throws Throwable {
        Statement statement = new Statement();
        result = subject.check(statement);
    }

    @When("^wprowadz oswiadczenie wspólne \"([^\"]*)\" z liczbą godzin \"([^\"]*)\"$")
    public void wprowadzOswiadczenieWspólne(List<String> courseOfStudies, String hoursAmount) throws Throwable {
        Statement statement = new Statement();
        result = subject.check(statement);
    }

    @Then("^oswiadczenie zostanie złożone$")
    public void oswiadczenieZostanieZłożone() throws Throwable {
        assertThat(result)
                .isNotNull()
                .extracting(Result::isAccepted)
                .contains(true);

        assertThat(result.getProblems()).isEmpty();
    }

    @Then("^oswiadczenie nie zostanie przyjęte z komunikatem \"([^\"]*)\"$")
    public void oswiadczenieNieZostaniePrzyjęteZKomunikatem(String info) throws Throwable {
        assertThat(result)
                .isNotNull()
                .extracting(Result::isAccepted, Result::isSuspended)
                .contains(true, true);

        assertThat(result.getProblems())
                .extracting(Ruleska::toString)
                .contains(info);
    }

    @Value
    public static class CourseOfStudyDefinition {
        String name;
        String courseOfStudy;
        String profile;
        int level;
    }
}
