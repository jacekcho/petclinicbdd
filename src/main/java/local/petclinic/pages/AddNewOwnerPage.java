package local.petclinic.pages;

import com.codeborne.selenide.SelenideElement;
import local.petclinic.dictionary.TestDataKey;
import local.petclinic.utils.Generators;
import local.petclinic.utils.DataContext;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class AddNewOwnerPage {

    @FindBy(id = "firstName")
    private SelenideElement firstNameInput;

    @FindBy(id = "lastName")
    private SelenideElement lastNameInput;

    @FindBy(id = "address")
    private SelenideElement addressInput;

    @FindBy(id = "city")
    private SelenideElement cityInput;

    @FindBy(id = "telephone")
    private SelenideElement telephoneInput;

    @FindBy(css = "button[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = "table[class = 'table table-striped']")
    private SelenideElement newOwnerSummaryTable;

    public AddNewOwnerPage() {
        page(this);
    }

    public void enterRandomValuesForNewOwner() {
        enterFirstName(Generators.randomFirstName());
        enterLastName(Generators.randomLastName());
        enterAddress(Generators.randomAddress());
        enterRandomCity(Generators.randomCity());
        enterTelephone(Generators.randomTelephoneNumber());
    }

    public void submitAndAddNewOwner() {
        submitButton.click();
    }

    public boolean isNewOwnerSummaryTableDisplayed() {
        return newOwnerSummaryTable.isDisplayed();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void enterRandomCity(String city) {
        cityInput.sendKeys(city);
    }

    public void enterTelephone(String telephone) {
        telephoneInput.sendKeys(telephone);
    }

}