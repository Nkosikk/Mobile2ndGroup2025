package Steps;

import Utils.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

public class Hooks {

    protected static AppiumDriver driver;

    public Hooks() {
        this.driver = AppiumDriverFactory.getDriver();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

}
