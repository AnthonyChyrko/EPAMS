package util;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Artur_Barkou on 8/24/2017.
 */
public class Waiter {

    public static boolean isElementPresent(By element){
        RemoteWebDriver driver = Driver.getInstance().getDriver();
        boolean result = driver.findElements(element).size() > 0;
        return result;
    }
}
