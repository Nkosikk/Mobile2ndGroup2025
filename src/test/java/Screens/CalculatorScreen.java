package Screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class CalculatorScreen {
    private AndroidDriver driver;

    @FindBy(id = "com.google.android.calculator:id/Nkosidigit_1")
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
        System.out.println("pressDigitOne called");
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
