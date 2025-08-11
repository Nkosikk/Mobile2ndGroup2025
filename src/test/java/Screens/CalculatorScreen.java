package Screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorScreen {
    private AndroidDriver driver;

    @FindBy(id = "com.google.android.calculator:id/digit_1")
    WebElement digitOne;

    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement plusOperator;

    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement equalsOperator;

    @FindBy(id = "com.google.android.calculator:id/result_preview")
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
        return resultPreview.getText();
    }


}
