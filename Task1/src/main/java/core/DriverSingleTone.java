package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSingleTone {

	private static WebDriverWait wait;
	public static WebDriver instance;
	
	private DriverSingleTone()
	{
		
	}
	public static WebDriver getDriver(String desiredBrowser)
	{
			if(instance==null)
			{
				switch (desiredBrowser)
				{
				case "chrome":
					System.setProperty("webdriver.chrome.driver", "../Task1/webdrivers/chromedriver.exe");
					instance=new ChromeDriver();
					return instance;
				case "firefox":
					System.setProperty("webdriver.gecko.driver","../Task1/webdrivers/geckodriver.exe");
					instance=new FirefoxDriver();
					return instance;
				default:
					break;
				}
			}
		
		return instance;
		
	}
	public  static WebElement findElement(By by) {
        try {
            WebDriverWait wait1 = new WebDriverWait(instance, 5);
            return  wait1.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            return NullWebElement.getNull();
        }
    }
	public static List<WebElement> findElements(By by)
		{
	        WebDriverWait wait = new WebDriverWait(instance, 5);
	        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	    }
	public static String getCurrentUrl()
	{
		return instance.getCurrentUrl();
	}
	public static WebDriverWait getWebDriverWait()
	{
		if(wait==null)
		{
			
			wait=new WebDriverWait(instance, 5);
		}
		return new WebDriverWait(instance, 5);
	}
	public static void destoryDriver()
	{
		if(instance!=null)
		{
			instance.quit();
			instance=null;
		}
	}

}
