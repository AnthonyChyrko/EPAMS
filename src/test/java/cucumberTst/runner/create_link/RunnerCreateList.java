package cucumberTst.runner.create_link;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Anton_Chyrko on 8/22/2017.
 */
@CucumberOptions(plugin = {"json:target/cucumber-report.json",
        "html:target/cucumber-report"}, features = "src/test/resources/cucumberFeature/create_link/",
        glue = "cucumberTst.step.create_link")


public class RunnerCreateList extends AbstractTestNGCucumberTests {
}
