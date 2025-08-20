package Steps;

import Screens.CalculatorScreen;
import Utils.AppiumDriverFactory;
import io.cucumber.java.en.*;

import java.net.MalformedURLException;


public class StepsDifination_Calculator {

    CalculatorScreen calculatorScreen;

    @Given("I have a Calculator app")
    public void i_have_a_calculator_app() throws MalformedURLException {
        // iOS Safari app bundle ID
        String bundleId = "com.apple.mobilesafari";
        AppiumDriverFactory.getInstanceOfAppiumDriverFactory(bundleId, true); // true for iOS
        this.calculatorScreen = new CalculatorScreen(AppiumDriverFactory.getDriver());
    }

    @And("I click on the number one button")
    public void i_click_on_the_number_one_button() {
        calculatorScreen.pressDigitOne();
        calculatorScreen.pressDigitOne();
    }

    @And("I click on the plus sign button")
    public void i_click_on_the_plus_sign_button() {
        calculatorScreen.pressPlusOperator();
    }

    @And("I click on the equals button")
    public void i_click_on_the_equals_button() {
        calculatorScreen.pressEqualsOperator();
    }
}
