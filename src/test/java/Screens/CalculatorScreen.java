package Screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class CalculatorScreen {
    private final AndroidDriver driver;

    @FindBy(id = "com.google.android.calculator:id/digit_1")
    WebElement digitOne;

    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement plusOperator;

    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement equalsOperator;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement resultPreview;

    public CalculatorScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pressDigitOne() {
        digitOne.click();
    }
    public void pressPlusOperator() {
        plusOperator.click();
    }

    public void pressEqualsOperator() {
        equalsOperator.click();
    }
    public String getResultPreview() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(resultPreview));
        return resultPreview.getText();
//        try {
//            String result = resultPreview.getText();
//            System.out.println("Result: " + result);
//            return result;
//        } catch (Exception e) {
//            System.out.println("Unable to retrieve the result. Error: " + e.getMessage());
//            return null;
//        }
    }
}
