package autoIt;

import driver.Driver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Browser {
    public static synchronized RemoteWebDriver getAutoitDriver() {
// code snippet below is required to get host ip where webdriver is running
// just in case webdriver host ip is not set explicitly by some env parameter
/*
* String sessionId = ( ( CustomRemoteWebDriver ) webDriver
).getSessionId().toString(); String nodeHost =
* GridInfoExtracter.getHostNameAndPort( seleniumHost, Integer.parseInt(
seleniumPort ), sessionId )[0];
*/

        RemoteWebDriver autoitDriver = Driver.getInstance().getDriver();
        String seleniumHost = "10.6.102.31";

        if (autoitDriver != null) {
            return autoitDriver;
        } else {
            String nodeHost = seleniumHost;
          /*  logger.info( "Extracted selenium hostname for AutoIt server bind: " +
                    nodeHost );*/
            DesiredCapabilities autoItCapabilities = new
                    DesiredCapabilities();
            autoItCapabilities.setCapability("browserName", "AutoIt");
            try {
                autoitDriver =
                        new RemoteWebDriver(new URL("http://" + nodeHost +
                                ":4723/wd/hub"), autoItCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return autoitDriver;
    }
}