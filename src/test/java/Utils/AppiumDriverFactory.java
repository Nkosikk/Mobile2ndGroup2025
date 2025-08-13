package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverFactory {

    private static AppiumDriver driver;

    public static AppiumDriverFactory instanceOfAppiumDriverFactory;

    public AppiumDriverFactory(String path) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", path);
        capabilities.setCapability("noReset", true);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(15, java.util.concurrent.TimeUnit.SECONDS);

    }

    public static AppiumDriverFactory getInstanceOfAppiumDriverFactory(String path) throws MalformedURLException {
        if (instanceOfAppiumDriverFactory == null) {
            instanceOfAppiumDriverFactory = new AppiumDriverFactory(path);
        }
        return instanceOfAppiumDriverFactory;
    }

    public static AndroidDriver getDriver() {
        return (AndroidDriver) driver;
    }


}
