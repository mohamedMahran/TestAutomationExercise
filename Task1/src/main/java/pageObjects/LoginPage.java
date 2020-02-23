package pageObjects;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilis.Helper;

public class LoginPage {



	public WebDriver driver;


	@FindBy(id = "SubmitCreate")
	private WebElement submitCreate;

	@FindBy(id = "email_create")
	private WebElement email;

	@FindBy(className = "login")
	private WebElement login;

	@FindBy(id = "email")
	private WebElement userEmailAddress;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement signin;

	@FindBy(className = "logout")
	private WebElement logout;

	public LoginPage(WebDriver driver) 
	{
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

	public void enterUserCredentialsAndSignIn() throws IOException {
		Helper.loadFromPropertiesFile();
		userEmailAddress.sendKeys(BasePage.prop.getProperty("existingUserEmail"));
		password.sendKeys(BasePage.prop.getProperty("existingUserPassword"));
		signin.click();

	}
	public void enterNewAccount()
	{
		email.sendKeys(Helper.createNewEmail());
	}

	public void clickOnCreateAccountButton() {
		// TODO Auto-generated method stub
		this.submitCreate.click();
	}


}
