package Steps;

import ScreensForApiDemos_debug.ApiDemos_AnimateDrawables;
import ScreensForApiDemos_debug.ApiDemos_GraphicsScreen;
import ScreensForApiDemos_debug.ApiDemos_HomeScreen;
import Utils.AppiumDriverFactory;
import io.cucumber.java.en.*;

import java.net.MalformedURLException;

public class StepsDefinition_ApiDemosDebug {

    ApiDemos_HomeScreen apiDemosHomeScreen;
    ApiDemos_GraphicsScreen apiDemosGraphicsScreen;

    ApiDemos_AnimateDrawables apiDemosAnimateDrawables;

    @Given("I have an ApiDemos app installed on my device")
    public void i_have_an_api_demos_app_installed_on_my_device() throws MalformedURLException {
        String apiDemoApp_Path = System.getProperty("user.dir") + "/src/main/Apps/ApiDemos-debug.apk";
        AppiumDriverFactory.getInstanceOfAppiumDriverFactory(apiDemoApp_Path);
        this.apiDemosHomeScreen = new ApiDemos_HomeScreen(AppiumDriverFactory.getDriver());
    }
    @And("I click on Graphics")
    public void i_click_on_graphics() {
        apiDemosHomeScreen.clickGraphicsText();
    }
    @When("I click on AnimationDrawable")
    public void i_click_on_animation_drawable() {
        apiDemosGraphicsScreen.clickAnimateDrawablesText();
    }
    @Then("I should see the picture of the AnimationDrawable")
    public void i_should_see_the_picture_of_the_animation_drawable() {
        apiDemosAnimateDrawables = new ApiDemos_AnimateDrawables(AppiumDriverFactory.getDriver());
        boolean isAnimationDrawableImageDisplayed = apiDemosAnimateDrawables.isAnimationDrawableImageDisplayed();
        if (!isAnimationDrawableImageDisplayed) {
            throw new AssertionError("Animation Drawable image is not displayed");
        }

    }

}
