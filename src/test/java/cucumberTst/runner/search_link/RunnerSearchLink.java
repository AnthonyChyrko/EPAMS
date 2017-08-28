package cucumberTst.runner.search_link;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import driver.Driver;
import org.testng.annotations.AfterClass;

@CucumberOptions(plugin = {"json:target/cucumber-report.json",
        "html:target/cucumber-report"}, features = "src/test/resources/cucumberFeature/search_link/",
        glue = "cucumberTst.step.search_link")
public class RunnerSearchLink extends AbstractTestNGCucumberTests {

    @AfterClass
    public void closeBrowser() {
        Driver.closeInstance();
    }
}


