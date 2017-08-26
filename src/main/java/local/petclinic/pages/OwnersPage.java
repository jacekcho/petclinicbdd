package local.petclinic.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class OwnersPage {

    @FindBy(css = "button[type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = "a[href^='/petclinic/owners/']")
    private List<SelenideElement> ownersList;

    @FindBy(css = "  a[href^='/petclinic/owners/new']")
    private SelenideElement newOwnerButton;

    public OwnersPage() {
        page(this);
    }

    public void clickSubmitButton() {
        $(submitButton).click();
    }

    public List<SelenideElement> getOwnersList() {
        return $$(ownersList);
    }

    public void clickAddOwnerButton() {
        $(newOwnerButton).click();
    }

}