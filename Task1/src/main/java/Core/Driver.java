package Core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class  Driver {

			private static final long WAIT_SECONDS = 5;
	        private static WebDriverWait _browserWait;

	        public static  WebDriver _browser;
	        
	        public static WebDriver CreateInstance(String browser)
			{
				if (browser.equalsIgnoreCase("Chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "../Task1/driver/chromedriver.exe");
					return new ChromeDriver();
				}
				else if (browser.equalsIgnoreCase("IE"))
				{
					return new InternetExplorerDriver();
				}
				else
				{
					System.setProperty("webdriver.gecko.driver", "../Task1/driver/geckodriver.exe");
					return new FirefoxDriver();
				}
			}
	        
	        public static WebDriver getBrowser()
	        {
	            
	                if (_browser == null)
	                {
	                    try {
							throw new Exception("The WebDriver browser instance was not initialized. You should first call the method Start.");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	                return _browser;
	         
	           
	        }
	        
	        public void setBrowser(WebDriver browser)
	        {
	        	_browser=browser;
	        }

	        public static WebDriverWait getBrowserWait()
	        {
	            
	                if (_browserWait == null || _browser == null)
	                {
	                    try {
							throw new Exception("The WebDriver browser wait instance was not initialized. You should first call the method Start.");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	                return _browserWait;
	         }
	      
	        public void setBrowserWait(WebDriverWait browserWait)
	         {
	        	 _browserWait=browserWait;
	         }

	        public static void stopBrowser()
	        {
	            getBrowser().quit();
	            _browser = null;
	            _browserWait = null;
	            
	        }
	       
	        public static int getCurrentScreenWidth()
	        {
	            return _browser.manage().window().getSize().width;
	        }

	        public static String getCurrentUrl()
	        {
	            return _browser.getCurrentUrl();
	        }
	       
	        public static void ScrollToElement(WebElement element)
	        {
	        	Actions actions = new Actions(_browser);
	            actions.moveToElement(element);
	            actions.perform();
	        }

	        public static void back()
	        {
	        	_browser.navigate().back();
	        }
	  
	        public  static void navigate(String url)
	        {
	        	_browser.get(url);
	        }
	      
	        public static void start(String url) {
	        	_browser.get(url);
		    }

		    public void stop() {
		    	_browser.quit();
		    }

		    public static Object executeJavaScript(String script) {
		        return ((JavascriptExecutor) _browser).executeScript(script);
		    }

		    public static WebElement findElement(By by) {
		        try {
		            WebDriverWait wait = new WebDriverWait(_browser, WAIT_SECONDS);
		            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		        } catch (Exception ex) {
		            return NullWebElement.getNull();
		        }
		    }
		
		  
		    public  static void implicitWait()
	        {
		    	_browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        }
		   
		    public  static void maximize()
	        {
		    	_browser.manage().window().maximize();
	        }

		    public static List<WebElement> findElements(By by) {
		        WebDriverWait wait = new WebDriverWait(_browser, WAIT_SECONDS);
		        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		    }
	      

}
