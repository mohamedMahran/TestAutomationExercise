package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFacade    {
    private static final long WAIT_SECONDS = 10;
	public static WebDriver driver;
	
	

	public WebDriverFacade(String browser) {
        
		driver = WebDriverFactory.createWebDriver(browser);
    }
    public  void start(String url) {
        driver.get(url); 
    }
    
    public  void maximize()
    {
    	driver.manage().window().maximize();
    }

    public  void stop() {
        driver.quit();
    }
    
    public WebElement findElement(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
            return  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            return NullWebElement.getNull();
        }
    }

    public List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
	
    public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	
    }
    
    public Object executeJavaScript(String script) {
        return ((JavascriptExecutor) driver).executeScript(script);
    }


}