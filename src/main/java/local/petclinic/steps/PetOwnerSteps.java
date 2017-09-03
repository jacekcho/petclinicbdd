package local.petclinic.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import local.petclinic.dictionary.TestDataKey;
import local.petclinic.pages.AddNewOwnerPage;
import local.petclinic.pages.OwnersPage;
import local.petclinic.utils.TestData;

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
        assertThat(ownersPage.getPageHeader()).as("Wrong header").isEqualTo("Owners");
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

    @And("^enter created owner name in the search owner form$")
    public void enteredCreatedOwnerNameInTheSearchOwnerForm() {
        String ownerName = TestData.get(TestDataKey.LAST_NAME);
        ownersPage.enterOwnerNameInTheSearchOwnerForm(ownerName);
    }

    @Then("^User see created owner data$")
    public void userSeeCreatedOwnerData() {
        assertThat(ownersPage.getPageHeader()).as("Wrong header").isEqualTo("Owner Information");
        assertThat(ownersPage.getOwnerData()).as("Wrong owner data").contains(TestData.get(TestDataKey.FIRST_NAME));
        assertThat(ownersPage.getOwnerData()).as("Wrong owner data").contains(TestData.get(TestDataKey.LAST_NAME));
        assertThat(ownersPage.getOwnerData()).as("Wrong owner data").contains(TestData.get(TestDataKey.ADDRESS));
        assertThat(ownersPage.getOwnerData()).as("Wrong owner data").contains(TestData.get(TestDataKey.TELEPHONE));
        assertThat(ownersPage.getOwnerData()).as("Wrong owner data").contains(TestData.get(TestDataKey.CITY));
    }

    @And("^create new owner$")
    public void createNewOwner() {
        ownersPage.clickAddOwnerButton();
        addNewOwnerPage.enterRandomValuesForNewOwner();
        addNewOwnerPage.submitAndAddNewOwner();
    }

    @And("^enter random first name$")
    public void enterRandomFirstName() {
        addNewOwnerPage.enterRandomFirstName();
    }

    @And("^enter random last name$")
    public void enterRandomLastName() {
        addNewOwnerPage.enterRandomLastName();
    }

    @And("^enter random address$")
    public void enterRandomAddress() {
        addNewOwnerPage.enterRandomAddress();
    }

    @And("^enter random city$")
    public void enterRandomCity() {
        addNewOwnerPage.enterRandomCity();
    }

    @And("^enter random telephone$")
    public void enterRandomTelephone() {
        addNewOwnerPage.enterRandomTelephone();
    }
}