package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Driver {
    private final RemoteWebDriver driver;
    private static final String PROPERTIES_FILE = "src/test/resources/driver.properties";
    private static Browser currentBrowser;
    private static Driver instance;
    private static int defaultImplicitWaitTimeOut;
    private static int defaultExplicitWaitTimeout;
    private static String url;

    private Driver(){
        driver = setUpDriver();
    }

    public static synchronized Driver getInstance(){
        if (instance == null){
            instance = new Driver();
        }
        return instance;
    }

    public static void closeInstance(){
        if (instance.driver != null){
            instance.driver.quit();
        }
        instance = null;
    }

    private RemoteWebDriver setUpDriver() {
        RemoteWebDriver driver = null;
        initProperties();

        switch (currentBrowser){
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

        }

        driver.manage().timeouts().implicitlyWait(defaultImplicitWaitTimeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(defaultImplicitWaitTimeOut, TimeUnit.SECONDS);

        return driver;
    }



    public RemoteWebDriver getDriver(){
        return driver;
    }

    public static int getDefaultImplicitWaitTimeOut() {
        return defaultImplicitWaitTimeOut;
    }

    public static int getDefaultExplicitWaitTimeout() {
        return defaultExplicitWaitTimeout;
    }

    public static String getUrl() {
        return url;
    }

    private static void initProperties(){
        Properties properties = null;
        try(FileInputStream fileProperty = new FileInputStream(PROPERTIES_FILE)) {
            properties = new Properties();
            properties.load(fileProperty);
            defaultImplicitWaitTimeOut = Integer.parseInt(properties.getProperty("defaultImplicitWaitTimeout"));
            defaultExplicitWaitTimeout = Integer.parseInt(properties.getProperty("defaultExplicitWaitTimeout"));
            url = properties.getProperty("url");
            currentBrowser = Browser.valueOf(properties.getProperty("browser").toUpperCase());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum Browser{
        CHROME,
        FIREFOX
    }

}
