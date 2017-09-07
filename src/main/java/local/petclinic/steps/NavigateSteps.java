package local.petclinic.steps;

import cucumber.api.java.en.When;
import local.petclinic.pages.PetclinicMainPage;

import static org.fest.assertions.api.Assertions.assertThat;

public class NavigateSteps {

    private PetclinicMainPage petclinicMainPage = new PetclinicMainPage();

    private final String MAIN_PAGE_TITLE = "PetClinic :: a Spring Framework demonstration";

    @When("User is on home page$")
    public void userIsOnHomePage() {
        assertThat(petclinicMainPage.goToMainPage()).as("Not on the main page").contains(MAIN_PAGE_TITLE);
    }

    @When("^go to find owner page$")
    public void clickTheFindOwnersBookmark() {
        petclinicMainPage.clickFindOwnersBookmark();
    }

}
