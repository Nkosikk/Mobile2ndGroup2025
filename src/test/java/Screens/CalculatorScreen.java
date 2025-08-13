package Screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorScreen {
    private AppiumDriver driver;

    // iOS Calculator app locators using accessibility IDs

    @FindBy(xpath="//XCUIElementTypeKey[@name=\"One\"]")
    WebElement digitOne;

    @FindBy(id = "+")
    WebElement plusOperator;

    @FindBy(id = "=")
    WebElement equalsOperator;

    // Result display element
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Result']")
    WebElement resultPreview;

    public CalculatorScreen(AppiumDriver driver) {
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
