package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage extends BasePage {
	private   LoginPage loginPage ;

	public WebDriver driver;
	
	@FindBy(className = "login")
	private WebElement signIn;

	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		if (driver != null) {

			PageFactory.initElements(driver, this);

		} else {
			try {
				throw new Exception("Driver doesn't instintiated");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public LoginPage signIn()
	{
		signIn.click();
		return loginPage;
	}

}
