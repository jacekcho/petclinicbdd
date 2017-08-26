package local.petclinic.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import local.petclinic.pages.AddNewOwnerPage;
import local.petclinic.pages.OwnersPage;

import static org.fest.assertions.api.Assertions.assertThat;

public class PetOwnerSteps {

    private OwnersPage ownersPage = new OwnersPage();

    private AddNewOwnerPage addNewOwnerPage = new AddNewOwnerPage();

    @And("^click the Find Owner button$")
    public void clickTheFindOwnerButton() {
        ownersPage.clickSubmitButton();
    }

    @Then("^User see list of owners$")
    public void userSeeListOfOwners() {
        assertThat(ownersPage.getOwnersList()).as("Owners list is empty").isNotEmpty();
    }

    @When("^click Add Owner button$")
    public void clickAddOwnerButton() {
        ownersPage.clickAddOwnerButton();
    }

    @And("^enter random values for new owner$")
    public void enterRandomValuesForNewOwner() {
        addNewOwnerPage.enterRandomValuesForNewOwner();
    }

    @And("^click submit and add owner$")
    public void clickSubmitAndAddOwner() {
        addNewOwnerPage.submitAndAddNewOwner();
    }

    @Then("^User see summary page after added new owner$")
    public void userSeeSummaryPageAfterAddedNewOwner() {
        assertThat(addNewOwnerPage.isNewOwnerSummaryTableDisplayed()).as("The new owner has not been created").isTrue();
    }
}