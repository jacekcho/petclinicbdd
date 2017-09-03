package local.petclinic.pages;

import com.codeborne.selenide.SelenideElement;
import local.petclinic.dictionary.TestDataKey;
import local.petclinic.utils.Generators;
import local.petclinic.utils.TestData;
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

    public void enterRandomFirstName() {
        String firstName = Generators.randomFirstName();
        TestData.set(TestDataKey.FIRST_NAME, firstName);
        firstNameInput.sendKeys(firstName);
    }

    public void enterRandomLastName() {
        String lastName = Generators.randomLastName();
        TestData.set(TestDataKey.LAST_NAME, lastName);
        lastNameInput.sendKeys(lastName);
    }

    public void enterRandomAddress() {
        String address = Generators.randomAddress();
        TestData.set(TestDataKey.ADDRESS, address);
        addressInput.sendKeys(address);
    }

    public void enterRandomCity() {
        String city = Generators.randomCity();
        TestData.set(TestDataKey.CITY, city);
        cityInput.sendKeys(city);
    }

    public void enterRandomTelephone() {
        String telephone = Generators.randomTelephoneNumber();
        TestData.set(TestDataKey.TELEPHONE, telephone);
        telephoneInput.sendKeys(telephone);
    }

}