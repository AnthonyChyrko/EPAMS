package cucumberTst.step;

import driver.Driver;
import org.openqa.selenium.remote.RemoteWebDriver;
import page.EpamsLoginPage;
import page.EpamsMainPage;
import test.AbstractTest;

public abstract class AbstractStep extends AbstractTest {
    public AbstractStep() {
        RemoteWebDriver driver = Driver.getInstance().getDriver();
        driver.get(Driver.getUrl());
        EpamsLoginPage epamsLoginPage = new EpamsLoginPage();
        mainPage = epamsLoginPage.logIn();
    }

}
