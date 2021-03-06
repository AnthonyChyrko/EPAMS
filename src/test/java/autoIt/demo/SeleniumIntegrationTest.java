package autoIt.demo;

import driver.Driver;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.interactions.*;
import java.net.URL;

public class SeleniumIntegrationTest {

	public WebDriver webDriver, autoitDriver;
	public DesiredCapabilities autoItCapabilities;

	@Before
	public void setUp() throws Exception {

//	  System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//	  String hubHost = "localhost";
//		webDriver = new RemoteWebDriver(new URL("http://"+hubHost +":4444/wd/hub" ), capabilities);
//
//		String sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
//		String nodeHost = GridInfoExtracter.getHostNameAndPort(hubHost, 4444, sessionId)[0];
//		System.out.println("Extracted hostname: "+nodeHost);

		webDriver = Driver.getInstance().getDriver();

		String seleniumHost = "10.6.103.25";
		autoItCapabilities = new DesiredCapabilities();
		autoItCapabilities.setCapability("browserName", "AutoIt");
		autoitDriver = new RemoteWebDriver(new URL("http://"+seleniumHost+":4723/wd/hub" ), autoItCapabilities);

//		IP address can be specified explicitly, as shown below
//		autoitDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub" ), autoItCapabilities);
	}

	@After
	public void tearDown() throws Exception {
		webDriver.close();
		autoitDriver.quit();
	}

	@Test
	public void test() throws Exception {
		// ### HTTP authentication dialog popup demo ###
		webDriver.get("http://www.httpwatch.com/httpgallery/authentication/");
		Thread.sleep(1000);
		// check state that img is "unauthenticated" at start
		String imgSrc = webDriver.findElement(By.id("downloadImg")).getAttribute("src");
		System.out.println(imgSrc);
		Assert.assertNull("HTTP demo test fail because test site not started with correct default unauthenticated state.",imgSrc);

		// now test authentication
		webDriver.findElement(By.id("displayImage")).click(); // trigger the popup
		Thread.sleep(5000); // wait for popup to appear
		autoitDriver.switchTo().window("Authentication Required");
		new Actions(autoitDriver).sendKeys("httpwatch{TAB}AutoItDriverServerAndSeleniumIntegrationDemo{TAB}{ENTER}").build().perform();
		Thread.sleep(5000);

		// now check img is authenticated or changed
		imgSrc = webDriver.findElement(By.id("downloadImg")).getAttribute("src");
		Assert.assertFalse("HTTP demo failed, image didn't authenticate/change after logging in.",imgSrc.contains("/images/spacer.gif"));


		// below is some demo code which should be adjusted for exact test data and site content
		// file upload demo is already implemented for real project code
		/*// ### file upload demo, also adapted from sample code of the test/target site ###
		webDriver.get("http://www.toolsqa.com/automation-practice-form");
		// webDriver.findElement(By.id("photo")).click(); // this doesn't seem to trigger file upload to popup
		WebElement elem = webDriver.findElement(By.id("photo"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",elem);
		Thread.sleep(5000); // wait for file upload dialog to appear
		autoitDriver.switchTo().window("File Upload");

		 FYI, on FF, Opera, (Windows Safari) filename field control ID may be 1152
		 * but on IE, Chrome, and Windows in general, should be control ID should be 1148

		//uncomment line below if want to transfer file from Selenium code execution machine A to remote node B before typing in actual file path at target node B
		//((RemoteWebDriver) autoitDriver).setFileDetector(new LocalFileDetector());
		autoitDriver.findElement(By.className("Edit1")).sendKeys("C:\\ReplaceWith\\PathTo\\AnActualFileOnRemoteNode.txt");
		Thread.sleep(2000);
		autoitDriver.findElement(By.className("Button1")).click();
		//new Actions(autoitDriver).sendKeys("{ENTER}").perform(); // another option to "click" Open/Upload
		//new Actions(autoitDriver).sendKeys("!o").perform(); // another option to invoke Open/Upload via keyboard shortcut ALT + O
		Thread.sleep(5000);

		// execute an AutoIt script from WebDriver
		((JavascriptExecutor) autoitDriver).executeScript("C:\\PathOnAutoItDriverServerHostMachineTo\\demo.au3","Hello","World");*/
	}

}
