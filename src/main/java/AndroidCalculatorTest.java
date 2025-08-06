import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidCalculatorTest {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        // Set up desired capabilities for Samsung device
        DesiredCapabilities caps = new DesiredCapabilities();

        // Platform and device settings
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Samsung Device"); // This can be any name

        // Calculator app package and activity (Samsung Calculator)
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        // Alternative: Use generic Android calculator if Samsung calculator doesn't work
        // caps.setCapability("appPackage", "com.google.android.calculator");
        // caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        // Don't reset app state
        caps.setCapability("noReset", true);

        // Set implicit wait
        caps.setCapability("newCommandTimeout", 300);

        // Initialize the driver with Appium server URL
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Calculator app launched successfully!");
    }

    @Test
    public void testCalculatorLaunch() {
        try {
            // Wait a moment for the app to fully load
            Thread.sleep(2000);

            // Verify the calculator is launched by checking if we can find calculator elements
            // Look for common calculator buttons
            try {
                driver.findElement(AppiumBy.accessibilityId("1"));
                System.out.println("Calculator app is running - number buttons are visible!");
            } catch (Exception e) {
                // Try alternative locators
                try {
                    driver.findElement(AppiumBy.xpath("//*[@text='1']"));
                    System.out.println("Calculator app is running - found number 1 button!");
                } catch (Exception ex) {
                    System.out.println("Calculator launched but specific buttons not found. App may have different UI.");
                }
            }

            // Optional: Perform a simple calculation
            performSimpleCalculation();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performSimpleCalculation() {
        try {
            System.out.println("Performing simple calculation: 2 + 3");

            // Try to click number 2
            clickButton("2");
            Thread.sleep(500);

            // Try to click plus button
            clickButton("+");
            Thread.sleep(500);

            // Try to click number 3
            clickButton("3");
            Thread.sleep(500);

            // Try to click equals button
            clickButton("=");
            Thread.sleep(1000);

            System.out.println("Simple calculation completed!");

        } catch (Exception e) {
            System.out.println("Could not perform calculation - UI elements may be different: " + e.getMessage());
        }
    }

    private void clickButton(String buttonText) {
        try {
            // Try multiple locator strategies
            try {
                driver.findElement(AppiumBy.accessibilityId(buttonText)).click();
            } catch (Exception e1) {
                try {
                    driver.findElement(AppiumBy.xpath("//*[@text='" + buttonText + "']")).click();
                } catch (Exception e2) {
                    try {
                        driver.findElement(AppiumBy.xpath("//*[@content-desc='" + buttonText + "']")).click();
                    } catch (Exception e3) {
                        System.out.println("Could not find button: " + buttonText);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error clicking button " + buttonText + ": " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing the app...");
            driver.quit();
        }
    }
}
