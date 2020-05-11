package automationPracticeTests;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import Core.BasePage;
import Core.Driver;
import Core.Helper;
public class BaseTest extends Driver {
	    
		
		Logger log = Logger.getLogger(BasePage.class);
		
		@BeforeMethod
		@Parameters("browser")
		public void navigateTo(String browser) throws IOException {
			String url = Helper.load("url");
			if (System.getProperty("os.name").contains("Window")) {
					
					_browser= Driver.CreateInstance(browser);
					Driver.start(url);
					Driver.implicitWait();
					Driver.maximize();
					log.info("entering application URL");

				} 
				else if (System.getProperty("os.name").contains("Mac")) 
				{
					_browser= Driver.CreateInstance(browser);
					Driver.implicitWait();
					Driver.start(url);
					Driver.implicitWait();
					Driver.maximize();
					log.info("entering application URL");
					} 
		}

		@AfterMethod
		public void teardown(ITestResult result) throws IOException {
			if (ITestResult.FAILURE == result.getStatus()) {
				Helper.takeScreenShot(_browser, result.getName());
			}
			Driver.stopBrowser();

		}

}
