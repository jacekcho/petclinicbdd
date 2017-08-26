package local.petclinic.pages;

import com.codeborne.selenide.SelenideElement;
import local.petclinic.utils.PropertiesManager;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class PetclinicMainPage {

    @FindBy(css = "a[href='/petclinic/']")
    private SelenideElement homeBookmark;

    @FindBy(css = "a[href='/petclinic/owners/find.html']")
    private SelenideElement findOwnersBookmark;

    @FindBy(css = "a[href='/petclinic/vets.html']")
    private SelenideElement veterinariansBookmark;

    @FindBy(css = "a[href='/petclinic/oups.html']")
    private SelenideElement errorBookmark;

    @FindBy(css = "a[href='#']")
    private SelenideElement helpBookmark;

    public PetclinicMainPage() {
        page(this);
    }

    public String goToMainPage() {
        String petClinicUrl = PropertiesManager.getInstance().getPetClinicUrl();
        open(petClinicUrl);
        return title();
    }

    public boolean isHomeBookmarkDisplayed() {
        return $(homeBookmark).isDisplayed();
    }

    public boolean isFindOwnerBookmarkDisplayed() {
        return $(findOwnersBookmark).isDisplayed();
    }

    public boolean isVeterinariansBookmarkDisplayed() {
        return $(veterinariansBookmark).isDisplayed();
    }

    public boolean isErrorBookmarkDisplayed() {
        return $(errorBookmark).isDisplayed();
    }

    public boolean isHelpBookmarkDisplayed() {
        return $(helpBookmark).isDisplayed();
    }

    public void clickFindOwnersBookmark() {
        $(findOwnersBookmark).click();
    }

}