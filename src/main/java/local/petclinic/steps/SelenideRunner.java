package local.petclinic.steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SelenideRunner {

    @Before
    public void executeBeforeScenario() {
        selenideSettings();
    }

    @After
    public void executeAfterScenario() {
        Selenide.close();
    }

    private void selenideSettings() {
        ChromeDriverManager.getInstance().setup();
        System.setProperty("selenide.browser", "chrome");
    }
}