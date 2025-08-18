package Steps;

import Screens.CalculatorScreen;
import Utils.AppiumDriverFactory;
import io.cucumber.java.en.*;

import java.net.MalformedURLException;


public class StepsDefinition_Calculator {

    CalculatorScreen calculatorScreen;

    @Given("I have a Calculator app")
    public void i_have_a_calculator_app() throws MalformedURLException {
        String appPath = System.getProperty("user.dir") + "/src/main/Apps/Calculator.apk";
        AppiumDriverFactory.getInstanceOfAppiumDriverFactory(appPath);
        this.calculatorScreen = new CalculatorScreen(AppiumDriverFactory.getDriver());

    }

    @And("I click on the number one button")
    public void i_click_on_the_number_one_button() {
        calculatorScreen.pressDigitOne();
    }

    @And("I click on the plus sign button")
    public void i_click_on_the_plus_sign_button(){
        calculatorScreen.pressPlusOperator();
    }

    @When("I click on the equal sign button")
    public void i_click_on_the_equal_sign_button() {
        calculatorScreen.pressEqualsOperator();
    }

    @Then("the result should be number two")
    public void the_result_should_be_number_two() {

        String result = calculatorScreen.getResultPreview();
        System.out.println("The result displayed on the calculator is: " + result);
        if (!result.equals("2")) {
            throw new AssertionError("Expected result to be 2, but got " + result);

        }

    }


}
