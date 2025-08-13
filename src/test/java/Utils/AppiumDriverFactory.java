package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverFactory {

    private static AppiumDriver driver;

    public static AppiumDriverFactory instanceOfAppiumDriverFactory;

    public AppiumDriverFactory(String pathOrBundleId, boolean isIOS) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (isIOS) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("bundleId", pathOrBundleId);
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("udid", "00008130-00060D4E018A001C"); // Will use the connected device
//            capabilities.setCapability("platformVersion", "auto"); // Will detect iOS version

            try {
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("app", pathOrBundleId);
            capabilities.setCapability("noReset", true);

            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        driver.manage().timeouts().implicitlyWait(15, java.util.concurrent.TimeUnit.SECONDS);

    }

    public static AppiumDriverFactory getInstanceOfAppiumDriverFactory(String pathOrBundleId, boolean isIOS) throws MalformedURLException {
        if (instanceOfAppiumDriverFactory == null) {
            instanceOfAppiumDriverFactory = new AppiumDriverFactory(pathOrBundleId, isIOS);
        }
        return instanceOfAppiumDriverFactory;
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}
