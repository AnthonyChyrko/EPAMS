package cucumberTst.runner.edit_link;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import driver.Driver;
import org.testng.annotations.AfterClass;

/**
 * Created by Artur_Barkou on 8/24/2017.
 */
@CucumberOptions(plugin = {"json:target/cucumber-report.json",
        "html:target/cucumber-report"}, features = "src/test/resources/cucumberFeature/edit_link/",
        glue = "cucumberTst.step.edit_link")

public class RunnerEditLink extends AbstractTestNGCucumberTests {

    @AfterClass
    public void clearData() {
        Driver.closeInstance();
    }
}
