package utilis;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DriverSingleTone;
import core.WebDriverFacade;


public class Helper {
	private static Properties prop;
	private static String browser;
	private static WebDriver webDriver = DriverSingleTone.getDriver(browser);
	public static String getNewEmail()
	{
		 String timestamp = String.valueOf(new Date().getTime());
		 //generating random values for email address
		 return  "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
		 
	}
	public static void loadFromPropertiesFile() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../Task1/data.properties");
		prop.load(fis);
	}
	public static WebElement waitTillVisibilityofElement(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait( webDriver, timeout);
		return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static WebElement waitTillVisibilityOfListElement(List<WebElement> list, int timeout) {

		WebDriverWait wait = new WebDriverWait(webDriver, timeout);
		return  wait.until(ExpectedConditions.visibilityOfElementLocated((By) list));
	}
	public static void waitTillURLContains(String urlValidator, int seconds) {
		WebDriverWait wait = new WebDriverWait(webDriver,seconds );
		wait.until(ExpectedConditions.urlContains(urlValidator));
	}
	public static void waitTillURLMatches(String urlValidator, int seconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, seconds);
		wait.until(ExpectedConditions.urlMatches(urlValidator));
	}
	public static void waitTillURLIs(String url,int timeout) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeout);
		wait.until(ExpectedConditions.urlToBe(url));
	}
	public static String splitStringByArrow(List<String> list)
    {
		StringBuilder builder = new StringBuilder();
        for (String item : list)
        {
            builder.append(item).append(">");
        }
        return builder.toString();
    }
	public static String splitStringBySlash(List<String> list)
    {
		StringBuilder builder = new StringBuilder();
        for (String item : list)
        {
            builder.append(item).append("/");
            
        }
        return builder.toString();
    }
	public static void closeNewTabAndSwitchBackToOldOne() {
		ArrayList<String> tabs = new ArrayList<> (webDriver.getWindowHandles());
		WebDriverFacade.instance.close();
		WebDriverFacade.instance.switchTo().window(tabs.get(0));
	}
	public static void switchToLastTab() {
		ArrayList<String> tabs = new ArrayList<> (webDriver.getWindowHandles());
		WebDriverFacade.instance.switchTo().window(tabs.get(1));
	}
	public static void acceptAlertPopup()
    {
        try
        {
        	webDriver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException e){
        	
        }
        
    }
	public static void clickOn(List<WebElement> productList,String button)
    {
			try
			{
				
				
				List<WebElement> buttons =productList  ;

				for (WebElement btn : buttons)
				{
					
					String expectedButton= btn.getText();
					
					if (expectedButton.contains(button))
					{
						
						btn.click();
						break;
					}
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	public static List<String> getListOfclassNamesFromListOfElements(List<WebElement> webElements)
    {
		List<String> listOfElements = new ArrayList<>();
		for(WebElement t : webElements)
		{
			listOfElements.add(t.getAttribute("class"));
			
		}
	return listOfElements;	
    }
	public static List<String> getListOfonmousemoveattributeFromListOfElements(List<WebElement> webElements)
    {
		List<String> listOfOnMousemOveAttribute = new ArrayList<>();
		for(WebElement t : webElements)
		{
			listOfOnMousemOveAttribute.add(t.getAttribute("onmousemove"));
			
		}
        return listOfOnMousemOveAttribute;
    }
	public static List<String> getListOfStyleAttributeFromListOfElements(List<WebElement> webElements)
    {
		List<String> listOfStyleAttributes = new ArrayList<>();
		for(WebElement t : webElements)
		{
			listOfStyleAttributes.add(t.getAttribute("style"));
			
		}
        return listOfStyleAttributes;
       
    }
	public static List<String> getListOfStringsFromListOfElements(List<WebElement> ilist)
    {
		List<String> listOfStringsFromListOfElements = new ArrayList<>();
		for(WebElement t : ilist)
		{
			listOfStringsFromListOfElements.add(t.getText());
			
		}
        return listOfStringsFromListOfElements;
    }
	public static void hoverOn(WebElement element) throws InterruptedException {
		Actions builder = new Actions(webDriver);
		builder.moveToElement(element).perform();
		Thread.sleep(500);
		
	}
	public static String load(String property) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../Task1/data.properties");
		prop.load(fis);
		return prop.getProperty(property);
		
	}
}
