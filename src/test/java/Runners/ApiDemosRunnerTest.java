package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/ApiDemos_debug.feature",
        glue = {"Steps"},
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags = "@ApiDemosDebug"
)

public class ApiDemosRunnerTest extends AbstractTestNGCucumberTests {
}
