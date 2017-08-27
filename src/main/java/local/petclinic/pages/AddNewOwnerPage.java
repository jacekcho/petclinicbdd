package local.petclinic.pages;

import com.codeborne.selenide.SelenideElement;
import local.petclinic.utils.Generators;
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
        enterRandomFirstName();
        enterRandomLastName();
        enterRandomAddress();
        enterRandomCity();
        enterRandomTelephone();
    }

    public void submitAndAddNewOwner() {
        submitButton.click();
    }

    public boolean isNewOwnerSummaryTableDisplayed() {
        return newOwnerSummaryTable.isDisplayed();
    }

    private void enterRandomFirstName() {
        firstNameInput.sendKeys(Generators.randomFirstName());
    }

    private void enterRandomLastName() {
        lastNameInput.sendKeys(Generators.randomLastName());
    }

    private void enterRandomAddress() {
        addressInput.sendKeys(Generators.randomAddress());
    }

    private void enterRandomCity() {
        cityInput.sendKeys(Generators.randomCity());
    }

    private void enterRandomTelephone() {
        telephoneInput.sendKeys(Generators.randomTelephoneNumber());
    }

}