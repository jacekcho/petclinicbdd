package local.petclinic.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.screenshot;

public class SelenideRunner {

    @Before
    public void executeBeforeScenario() {
        selenideSettings();
    }

    @After
    public void executeAfterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File scrFile = new File(screenshot(scenario.getName()));
            byte[] screenshot = FileUtils.readFileToByteArray(scrFile);
            scenario.embed(screenshot, "image/png");
        }
    }

    private void selenideSettings() {
        ChromeDriverManager.getInstance().setup();
        System.setProperty("selenide.browser", "chrome");
    }
}