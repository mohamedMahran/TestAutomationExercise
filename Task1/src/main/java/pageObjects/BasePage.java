package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utilis.Helper;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public static Properties prop;
	public WebDriverWait wait;

	Logger log = Logger.getLogger(BasePage.class);

	public static String loadURL() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../Test/data.properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		return url;
	}

	@BeforeMethod
	@Parameters("browser")
	public void navigate(String browser) throws IOException {
		String url = loadURL();
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "../Test/driver/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				log.info("entering application URL");

			} 
			else if (browser.equals("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", "../Test/driver/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				log.info("entering application URL");

			} 
			else if (System.getProperty("os.name").contains("Mac")) 
			{
				if (browser.equals("chrome")) {
					System.setProperty("webdriver.chrome.driver", "../Test/driver/chromedriver.exe");
					driver = new ChromeDriver();
					driver.get(url);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					log.info("entering application URL");
					

				} else if (browser.equals("firefox")) {
					System.setProperty("webdriver.gecko.driver", "../Test/driver/geckodriver.exe");
					driver = new FirefoxDriver();
					driver.get(url);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					log.info("entering application URL");
				}
			}
		}
	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			Helper.takeScreenShot(driver, result.getName());
		}
		driver.quit();

	}

}
