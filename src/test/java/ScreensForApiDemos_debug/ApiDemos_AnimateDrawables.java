package ScreensForApiDemos_debug;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApiDemos_AnimateDrawables {
    private final AndroidDriver driver;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.view.View")
    WebElement animationDrawableImage;

    public ApiDemos_AnimateDrawables(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isAnimationDrawableImageDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).
                until(ExpectedConditions.visibilityOf(animationDrawableImage));
        try {
            return animationDrawableImage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
