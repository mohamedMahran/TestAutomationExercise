	package core;
	
	import java.io.File;
	import java.util.List;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	public class Driver {
	
		private static WebDriverWait wait;
		public static WebDriver instance;
		private static final String WEB_DRIVER_FOLDER = "webdrivers";
	
	private Driver() 
	{
	
	}
	
	public static WebDriver getDriver(String desiredBrowser) {
		if (instance == null) {
			Browser browser = Browser.fromString(desiredBrowser);// fromString function to return the type of the browser
			String driverFileName = browser.getName() + "driver.exe";// get the browser name
			String driverFilePath = driversFolder(new File("").getAbsolutePath());
			System.setProperty("webdriver." + browser.getName() + ".driver", driverFilePath + driverFileName);
	
			instance = browser.getDriver();
			return instance;
		}
	
		return instance;
	}
	
	private static String driversFolder(String path) {
		File file = new File(path);
		for (String item : file.list()) {
			if (WEB_DRIVER_FOLDER.equals(item)) {
				return file.getAbsolutePath() + "/" + WEB_DRIVER_FOLDER + "/";
				}
			}
			return driversFolder(file.getParent());
		}
	
		public static WebElement findElement(By by) {
			try {
				WebDriverWait wait1 = new WebDriverWait(instance, 5);
				return wait1.until(ExpectedConditions.visibilityOfElementLocated(by));
			} catch (Exception ex) {
				return NullWebElement.getNull(by);
			}
		}
	
		public static List<WebElement> findElements(By by) {
			WebDriverWait wait = new WebDriverWait(instance, 5);
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		}
	
		public static String getCurrentUrl() {
			return instance.getCurrentUrl();
		}
	
		public static WebDriverWait getWebDriverWait() {
			if (wait == null) {
	
				wait = new WebDriverWait(instance, 5);
			}
			return new WebDriverWait(instance, 5);
		}
	
		public static void destoryDriver() {
			if (instance != null) {
				instance.quit();
				instance = null;
			}
		}
	
	}
