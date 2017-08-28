package autoIt.demo;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



import java.net.URL;

public class OSAppsTest {

	public WebDriver driver;
	public DesiredCapabilities capabilities;

	@Before
	public void setUp() throws Exception {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "AutoIt");
		try {
			//   String seleniumHost = "10.6.102.31";
			driver = new RemoteWebDriver(new URL("http://10.6.102.31:4723/wd/hub" ), capabilities);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws Exception{

	  driver.get("C:\\Program Files (x86)\\Notepad++\\notepad++.exe");
		Thread.sleep(2000);
	 // DelayHelper.waitFor( 2 );
	  driver.switchTo().window("Notepad++");
	  new Actions(driver).sendKeys("{ALT}{ENTER}{N}").build().perform();
		Thread.sleep(2000);
	 // DelayHelper.waitFor( 2 );
    new Actions(driver).sendKeys("this is autoit typed text{ENTER}AutoItDriverServer moved the caret down{ENTER} and will open save file dialog{ALT}{ENTER}{s}").build().perform();
		Thread.sleep(2000);
   // DelayHelper.waitFor( 2 );
    driver.switchTo().window("Save As");
    driver.findElement(By.linkText( "Cancel")).click();
    Thread.sleep(2000);
	  
		driver.close();
	}
	}

