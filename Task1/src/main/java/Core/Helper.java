package core;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Helper {
	private static Properties prop;
	
	private static WebDriver driver;
	
	public static String createNewEmail()
	{
		 String timestamp = String.valueOf(new Date().getTime());
		 //generating random values for email address
		 String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
		 return email;
	}
//	public static void takeScreenShot(WebDriver webDriver,String result) throws IOException {
//		File scrFile =  ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
//		// Now you can do whatever you need to do with it, for example copy
//		// somewhere
//		String currentDir = System.getProperty("user.dir");
//		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//		try {
//			
//			FileUtils.copyFile(scrFile, new File(currentDir + result + timeStamp + ".png"));
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}
	
	public static void takeScreenShot(WebDriver webDriver,String result) throws IOException {
		File scrFile =  ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		String currentDir = System.getProperty("user.dir");
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		try {
			
			FileUtils.copyFile(scrFile, new File(currentDir + result + timeStamp + ".png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	public static void loadFromPropertiesFile() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../Task1/data.properties");
		prop.load(fis);
	}
	

	public static WebElement wait_Till_Visibility_of_Element(By locator, int timeout) {
		// Thread.Sleep(3);
		WebDriverWait wait = new WebDriverWait( driver, 30);
		return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static WebElement wait_Till_Visibility_of_List_Element(List<WebElement> list, int timeout) {
		// Thread.Sleep(3);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated((By) list));
	}

	public static void wait_Till_URL_Contains(String urlValidator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver,seconds );
		wait.until(ExpectedConditions.urlContains(urlValidator));
	}

	public static void wait_Till_URL_Matches(String urlValidator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.urlMatches(urlValidator));
	}

	public static void wait_Till_URL_Is(String url,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlToBe(url));
	}

	public static String convertListOfStringsToSingleStringArrowSeparated(List<String> list)
    {
		StringBuilder builder = new StringBuilder();
        for (String item : list)
        {
            builder.append(item).append(">");
        }
        return builder.toString();
    }

	public static String convertListOfStringsToSingleStringSlashSeparated(List<String> list)
    {
		StringBuilder builder = new StringBuilder();
        for (String item : list)
        {
            builder.append(item).append("/");
            
        }
        return builder.toString();
    }

	public static void closeNewTabAndSwitchBackToOldOne() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}

	public static void switchToLastTab() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public static void acceptAlertPopup()
    {
        try
        {
        	driver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException e){
        	
        }
        
    }
	public static void clickOn(List<WebElement> _productList,String button)
    {
			try
			{
				
				List<WebElement> buttons =_productList  ;

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
		
    
	public static List<String> getListOfclassNamesFromListOfElements(List<WebElement> WebElements)
    {
		List<String> listOfElements = new ArrayList<>();
		for(WebElement t : WebElements)
		{
			listOfElements.add(t.getAttribute("class"));
			
		}
	return listOfElements;	
    }

	public static List<String> getListOfonmousemoveattributeFromListOfElements(List<WebElement> WebElements)
    {
		List<String> listOfOnMousemOveAttribute = new ArrayList<>();
		for(WebElement t : WebElements)
		{
			listOfOnMousemOveAttribute.add(t.getAttribute("onmousemove"));
			
		}
        return listOfOnMousemOveAttribute;
    }

	public static List<String> Get_ListOfStyleAttribute_from_ListOfElements(List<WebElement> WebElements)
    {
		List<String> listOfStyleAttributes = new ArrayList<>();
		for(WebElement t : WebElements)
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

	public static void HoverOn(WebElement element) throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		Thread.sleep(500);
		
	}
	
	
	public static String load(String property) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../Task1/data.properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		return url;
	}
}
