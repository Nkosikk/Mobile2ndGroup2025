package ScreensForCalculator;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorScreen_2 {
    private final AndroidDriver driver;

    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement PlusOperator;

    @FindBy(id = "com.google.android.calculator:id/digit_5")
    WebElement digitFive;

    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement equalOperator;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement secondResultPreview;
    public CalculatorScreen_2(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void pressPlusOperator() {
        PlusOperator.click();
    }
    public void pressDigitFive() {
        digitFive.click();
    }
    public void pressEqualsOperator() {
        equalOperator.click();
    }
    public String getSecondResultPreview() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(secondResultPreview));
        return secondResultPreview.getText();
    }
}
