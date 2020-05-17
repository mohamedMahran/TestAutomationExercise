package automationPracticeTests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import core.Helper;
import core.WebDriverFacade;
public class BaseTest  {
	    

	public static WebDriverFacade webDriver;
	 @Parameters("browser")
	   @BeforeMethod
	    public void setUp(String browser) {
	    	String URL = null;
			try {
				URL = Helper.load("url");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        webDriver = new WebDriverFacade(browser);
	        webDriver.start(URL);
	        webDriver.maximize();
	    }
		@AfterMethod
		public void teardown(ITestResult result) throws IOException {
			if (ITestResult.FAILURE == result.getStatus()) {
				Helper.takeScreenShot( WebDriverFacade.driver, result.getName());
			}
			webDriver.stop();

		}

}
