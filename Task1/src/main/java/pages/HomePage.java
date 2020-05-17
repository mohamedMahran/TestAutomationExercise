package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.WebDriverFacade;


public class HomePage  {
	
	 //WebDriver webDriver;
	private WebDriverFacade webDriver;
		
//	 @FindBy( xpath= "//a[@title='Log in to your customer account']")
//	 private WebElement signIn;
	
//	public HomePage(WebDriver driver) {
//		this.webDriver=driver;
//		PageFactory.initElements(driver, this);
//	}
	 
	 public HomePage(WebDriverFacade webDriver) {
	        this.webDriver = webDriver;
	        //PageFactory.initElements(webDriver, this);
	    }
		private WebElement getSignInButton()
		{
			return webDriver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		}
	
	public void signIn()
	{
		// signIn = webDriver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		getSignInButton().click();
	}
	
//	public void signIn()
//	{
//		
//		 signIn.click();
//	}

}
