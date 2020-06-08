package org.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import core.DriverSingleTone;
import utilis.ReadPropertisFile;

public class BaseTest {

	private static  WebDriver driver=null;
	static WebDriverWait wait;
	static String url = null;
	static Logger log = Logger.getLogger(BaseTest.class);
	
	@Parameters("browser")
	@BeforeClass
	public static void setUp(String browser) 
	{

		driver = DriverSingleTone.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait=DriverSingleTone.getWebDriverWait();

	}

	@BeforeMethod()
	public static void goToHome() {
		try
		{
		url = ReadPropertisFile.getURL();
		driver.get(url);

		}
		catch(Exception ex)
		{
			log.info("Error in url",ex);
		}
	}

	@AfterClass
	public void tearDown() {
		DriverSingleTone.destoryDriver();
	}

}
