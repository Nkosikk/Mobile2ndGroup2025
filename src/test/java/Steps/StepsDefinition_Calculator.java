package Steps;

import ScreensForCalculator.CalculatorScreen_1;
import ScreensForCalculator.CalculatorScreen_2;
import Utils.AppiumDriverFactory;
import io.cucumber.java.en.*;

import java.net.MalformedURLException;

public class StepsDefinition_Calculator {

    CalculatorScreen_1 calculatorScreen_1;
    CalculatorScreen_2 calculatorScreen2;

    @Given("I have a Calculator app")
    public void i_have_a_calculator_app() throws MalformedURLException {
        String appPath = System.getProperty("user.dir") + "/src/main/Apps/Calculator.apk";
        AppiumDriverFactory.getInstanceOfAppiumDriverFactory(appPath);
        this.calculatorScreen_1 = new CalculatorScreen_1(AppiumDriverFactory.getDriver());

    }

    @And("I click on the number one button")
    public void i_click_on_the_number_one_button() {
        calculatorScreen_1.pressDigitOne();
    }

    @And("I click on the plus sign button")
    public void i_click_on_the_plus_sign_button() {
        calculatorScreen_1.pressPlusOperator();
    }

    @When("I click on the equal sign button")
    public void i_click_on_the_equal_sign_button() {
        calculatorScreen_1.pressEqualsOperator();
    }

    @Then("the result should be number two")
    public void the_result_should_be_number_two() {

        String result = calculatorScreen_1.getResultPreview();
        System.out.println("The result displayed on the calculator is: " + result);
        if (!result.equals("2")) {
            throw new AssertionError("Expected result to be 2, but got " + result);

        }

    }

    @Given("On the same Calculator app")
    public void onTheSameCalculatorApp() throws MalformedURLException {
        String appPath = System.getProperty("user.dir") + "/src/main/Apps/Calculator.apk";
        AppiumDriverFactory.getInstanceOfAppiumDriverFactory(appPath);
        this.calculatorScreen2 = new CalculatorScreen_2(AppiumDriverFactory.getDriver());
    }

    @And("I click on the plus sign button to add five")
    public void iClickOnThePlusSignButtonToAddFive() {
        calculatorScreen2.pressPlusOperator();
    }

    @Given("I click on the number five button")
    public void i_click_on_the_number_five_button() {
        calculatorScreen2.pressDigitFive();
    }

    @When("I click on the equal sign button again")
    public void i_click_on_the_equal_sign_button_again() {
        calculatorScreen2.pressEqualsOperator();
    }

    @Then("the result should be number negative {string}")
    public void theResultShouldBeNumberNegative(String arg0) {
        String actual = calculatorScreen2.getSecondResultPreview();
        System.out.println("The result displayed on the calculator is: " + actual
                + " and the expected result is: " + arg0);
    }
}
