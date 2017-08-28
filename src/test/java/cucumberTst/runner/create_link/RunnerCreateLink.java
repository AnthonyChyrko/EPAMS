package cucumberTst.runner.create_link;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import driver.Driver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import page.EpamsMainPage;

@CucumberOptions(plugin = {"json:target/cucumber-report.json",
        "html:target/cucumber-report"}, features = "src/test/resources/cucumberFeature/create_link/",
        glue = "cucumberTst.step.create_link")

public class RunnerCreateLink extends AbstractTestNGCucumberTests {

    @AfterClass
    public void closeBrowser() {
        Driver.closeInstance();
    }

}
