package ScreensForApiDemos_debug;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ApiDemos_HomeScreen {
    private final AndroidDriver driver;
    @FindBy(xpath = "//android.widget.TextView[@text=\"API Demos\"]")
    WebElement apiDemosText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Graphics\"]")
    WebElement graphicsText;

    public ApiDemos_HomeScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickGraphicsText() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(apiDemosText));
        graphicsText.click();
    }

}
