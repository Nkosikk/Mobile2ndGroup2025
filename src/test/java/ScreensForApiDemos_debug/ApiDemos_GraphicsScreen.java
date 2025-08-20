package ScreensForApiDemos_debug;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApiDemos_GraphicsScreen {
    private final AndroidDriver driver;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"AnimateDrawables\"]")
    WebElement animateDrawablesText;

    public ApiDemos_GraphicsScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickAnimateDrawablesText() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(animateDrawablesText));
        animateDrawablesText.click();
    }
}
