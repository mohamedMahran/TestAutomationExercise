package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Core.BasePage;



public class HomePage extends BasePage {
	private LoginPage loginPage ;

	@FindBy(className = "login")
	private WebElement signIn;
	

	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	public LoginPage signIn()
	{
		signIn.click();
		return loginPage;
	}

}
