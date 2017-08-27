package local.petclinic.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import local.petclinic.pages.PetclinicMainPage;

import static org.fest.assertions.api.Assertions.assertThat;

public class HomePageSteps {

    private PetclinicMainPage petclinicMainPage = new PetclinicMainPage();

    private final String MAIN_PAGE_TITLE = "PetClinic :: a Spring Framework demonstration";

    @When("User is on home page$")
    public void userIsOnHomePage() {
        assertThat(petclinicMainPage.goToMainPage()).as("Not on the main page").contains(MAIN_PAGE_TITLE);
    }

    @Then("^Home bookmark is displayed$")
    public void homeBookmarkIsDisplayed() {
        assertThat(petclinicMainPage.isHomeBookmarkDisplayed()).as("Home Bookmark is not displayed").isTrue();
    }

    @And("^Find owner bookmark is displayed$")
    public void findOwnerBookmarkIsDisplayed() {
        assertThat(petclinicMainPage.isFindOwnerBookmarkDisplayed()).as("Find owner Bookmark is not displayed").isTrue();
    }

    @And("^Veterinarians bookmark is displayed$")
    public void veterinariansBookmarkIsDisplayed() {
        assertThat(petclinicMainPage.isVeterinariansBookmarkDisplayed()).as("Veterinarians Bookmark is not displayed").isTrue();
    }

    @And("^Error bookmark is displayed$")
    public void errorBookmarkIsDisplayed() {
        assertThat(petclinicMainPage.isErrorBookmarkDisplayed()).as("Error Bookmark is not displayed").isTrue();
    }

    @And("^Help bookmark is displayed$")
    public void helpBookmarkIsDisplayed() {
        assertThat(petclinicMainPage.isHelpBookmarkDisplayed()).as("Help Bookmark is not displayed").isTrue();
    }

    @When("^click the Find Owners bookmark$")
    public void clickTheFindOwnersBookmark() {
        petclinicMainPage.clickFindOwnersBookmark();
    }

    @Then("^Welcome image is displayed$")
    public void welcomeImageIsDisplayed() {
        assertThat(petclinicMainPage.isPetsImageAvailable()).as("Welcome image not displayed").isTrue();
    }
}