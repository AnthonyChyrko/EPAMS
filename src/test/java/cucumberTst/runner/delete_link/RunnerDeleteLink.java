package cucumberTst.runner.delete_link;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

@CucumberOptions(plugin = {"json:target/cucumber-report.json",
        "html:target/cucumber-report"}, features = "src/test/resources/cucumberFeature/delete_link/",
        glue = "cucumberTst.step.delete_link")
public class RunnerDeleteLink extends AbstractTestNGCucumberTests {
    @AfterClass
    public void closeBrowser() {
        Driver.closeInstance();
    }
}


