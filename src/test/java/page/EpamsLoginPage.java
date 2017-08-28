package page;

import driver.Driver;
import element.LabelElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EpamsLoginPage {
    private final String AUTOIT_FOR_CHROME = "src/test/resources/logforchrome.exe";
    public WebDriver webDriver, autoitDriver;
    public DesiredCapabilities autoItCapabilities;

    public EpamsMainPage logIn() {

        LabelElement siteLogoElement = new LabelElement(EpamsMainPage.SITE_LOGO_LOCATOR);
        if (siteLogoElement.isPresent(5)) {
            return new EpamsMainPage();
        } else {
            String seleniumHost = "10.6.132.40";
            autoItCapabilities = new DesiredCapabilities();
            autoItCapabilities.setCapability("browserName", "AutoIt");
            try {
                autoitDriver = new RemoteWebDriver(new URL("http://" + seleniumHost + ":4723/wd/hub"), autoItCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
//            String login = System.getenv("MY_USER");
            String login = "MY_USER";
            System.out.println(login);
//            String pass = System.getenv("MY_PASSWORD");
            String pass = "MY_PASSWORD";
            try {
                Thread.sleep(5000); // wait for popup to appear
                autoitDriver.switchTo().window("Authentication Required");
                new Actions(autoitDriver).sendKeys(login+"{TAB}"+pass+"{TAB}{ENTER}").build().perform();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return new EpamsMainPage();
    }
}
