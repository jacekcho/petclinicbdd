package local.petclinic.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import local.petclinic.dictionary.TestDataKey;
import local.petclinic.injections.InjectOwners;
import local.petclinic.pages.AddNewOwnerPage;
import local.petclinic.pages.OwnersPage;
import local.petclinic.utils.DataContext;
import local.petclinic.utils.Generators;

import static org.fest.assertions.api.Assertions.assertThat;

public class PetOwnerSteps {

    private AddNewOwnerPage addNewOwnerPage = new AddNewOwnerPage();

    private OwnersPage ownersPage = new OwnersPage();

    private InjectOwners injectOwner = new InjectOwners();

    @And("^user clicks the Find Owner button$")
    public void clickTheFindOwnerButton() {
        ownersPage.clickSubmitButton();
    }

    @Then("^user see list of owners$")
    public void userSeeListOfOwners() {
        assertThat(ownersPage.getPageHeader()).as("Wrong header").isEqualTo("Owners");
        assertThat(ownersPage.getOwnersList()).as("InjectOwners list is empty").isNotEmpty();
    }

    @When("^click Add Owner button$")
    public void clickAddOwnerButton() {
        ownersPage.clickAddOwnerButton();
    }

    @And("^click submit and add owner$")
    public void clickSubmitAndAddOwner() {
        addNewOwnerPage.submitAndAddNewOwner();
    }

    @Then("^user see summary page after added new owner$")
    public void userSeeSummaryPageAfterAddedNewOwner() {
        assertThat(addNewOwnerPage.isNewOwnerSummaryTableDisplayed()).as("The new owner has not been created").isTrue();
    }

    @And("^enter created owner name in the search owner form$")
    public void enteredCreatedOwnerNameInTheSearchOwnerForm() {
        String ownerName = DataContext.getSavedData(TestDataKey.LAST_NAME);
        ownersPage.enterOwnerNameInTheSearchOwnerForm(ownerName);
    }

    @Then("^user see created owner data$")
    public void userSeeCreatedOwnerData() {
        assertThat(ownersPage.getPageHeader()).as("Wrong header").isEqualTo("Owner Information");
        assertThat(ownersPage.getOwnerData()).as("Wrong owner first name").contains(DataContext.getSavedData(TestDataKey.FIRST_NAME));
        assertThat(ownersPage.getOwnerData()).as("Wrong owner last name").contains(DataContext.getSavedData(TestDataKey.LAST_NAME));
        assertThat(ownersPage.getOwnerData()).as("Wrong owner address").contains(DataContext.getSavedData(TestDataKey.ADDRESS));
        assertThat(ownersPage.getOwnerData()).as("Wrong owner telephone").contains(DataContext.getSavedData(TestDataKey.TELEPHONE));
        assertThat(ownersPage.getOwnerData()).as("Wrong owner city").contains(DataContext.getSavedData(TestDataKey.CITY));
    }

    @And("^create new owner with random values$")
    public void injectNewOwnerWithRandomValues() {
        injectOwner.addOwner();
        DataContext.save(TestDataKey.LAST_NAME, injectOwner.getOwnerLastName());
        DataContext.save(TestDataKey.FIRST_NAME, injectOwner.getOwnerFirstName());
        DataContext.save(TestDataKey.ADDRESS, injectOwner.getOwnerAddress());
        DataContext.save(TestDataKey.CITY, injectOwner.getOwnerCity());
        DataContext.save(TestDataKey.TELEPHONE, injectOwner.getOwnerTelephone());
    }

    @And("^enter random first name$")
    public void enterRandomFirstName() {
        String firstName = Generators.randomFirstName();
        addNewOwnerPage.enterFirstName(firstName);
        DataContext.save(TestDataKey.FIRST_NAME, firstName);
    }

    @And("^enter random last name$")
    public void enterRandomLastName() {
        String lastName = Generators.randomLastName();
        addNewOwnerPage.enterLastName(lastName);
        DataContext.save(TestDataKey.LAST_NAME, lastName);
    }

    @And("^enter random address$")
    public void enterRandomAddress() {
        String address = Generators.randomAddress();
        addNewOwnerPage.enterAddress(address);
        DataContext.save(TestDataKey.ADDRESS, address);
    }

    @And("^enter random city$")
    public void enterRandomCity() {
        String city = Generators.randomCity();
        addNewOwnerPage.enterRandomCity(city);
        DataContext.save(TestDataKey.CITY, city);
    }

    @And("^enter random telephone$")
    public void enterRandomTelephone() {
        String telephone = Generators.randomTelephoneNumber();
        addNewOwnerPage.enterTelephone(telephone);
        DataContext.save(TestDataKey.TELEPHONE, telephone);
    }
}