package test;

import driver.Driver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import page.EpamsLoginPage;
import page.EpamsMainPage;
import util.LinkKey;
import util.XLSParser;

import java.io.File;
import java.util.List;
import java.util.Map;

public abstract class AbstractTest {

    private final String XLSX_PATH = "src/test/resources/links.xlsx";
    protected EpamsMainPage mainPage;
    List<Map<LinkKey, String>> links;

    @DataProvider(name = "long_links")
    public Object[][] longLinksCreator() {
        Object[][] data = new Object[links.size()][];
        for (int i = 0; i < links.size(); i++){
            data[i] = new Object[]{links.get(i).get(LinkKey.LONG_LINK)};
        }
        return data;
    }

    @DataProvider(name = "short_links")
    public Object[][] shortLinksCreator() {
        Object[][] data = new Object[links.size()][];
        for (int i = 0; i < links.size(); i++){
            Map<LinkKey, String> map = links.get(i);
            String longLink = map.get(LinkKey.LONG_LINK);
            String shortLink = map.get(LinkKey.SHORT_LINK);
            data[i] = new Object[]{longLink, shortLink};
        }
        return data;
    }



    @BeforeSuite
    public void setUp(){
        File file = new File(XLSX_PATH);
        links = XLSParser.parse(file);
        RemoteWebDriver driver = Driver.getInstance().getDriver();
        driver.get(Driver.getUrl());
    }

    @BeforeClass
    public void setUpMainPage(){
        mainPage = new EpamsLoginPage().logIn();
    }

    @AfterSuite
    public void tearDown(){
        Driver.closeInstance();
    }
}
