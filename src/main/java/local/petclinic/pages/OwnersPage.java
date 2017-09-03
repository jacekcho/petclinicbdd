package local.petclinic.pages;

import com.codeborne.selenide.SelenideElement;
import local.petclinic.dictionary.TestDataKey;
import local.petclinic.utils.TestData;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class OwnersPage {

    @FindBy(css = "button[type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = "a[href^='/petclinic/owners/']")
    private List<SelenideElement> ownersList;

    @FindBy(css = "a[href^='/petclinic/owners/new']")
    private SelenideElement newOwnerButton;

    @FindBy(css = "input[id='lastName']")
    private SelenideElement searchOwnerForm;

    @FindBy(css = "h2")
    private SelenideElement getHeader;

    @FindBy(css = "table[class='table table-striped']")
    private SelenideElement ownerData;

    public OwnersPage() {
        page(this);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public List<SelenideElement> getOwnersList() {
        return ownersList;
    }

    public void clickAddOwnerButton() {
        newOwnerButton.click();
    }

    public void enterOwnerNameInTheSearchOwnerForm(String ownerLastName) {
        searchOwnerForm.sendKeys(ownerLastName);
    }

    public String getPageHeader() {
        return getHeader.getText();
    }

    public String getOwnerData() {
        return ownerData.getText();
    }
}