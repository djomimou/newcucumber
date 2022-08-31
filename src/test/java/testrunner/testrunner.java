package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = "stepdefinition",stepNotifications = true,monochrome = true,
        plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class testrunner
{
}
