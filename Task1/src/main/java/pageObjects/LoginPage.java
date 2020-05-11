package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Core.BasePage;
import Core.Helper;

public class LoginPage extends BasePage {

	public static Properties prop;

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
	super(driver);
	}

	public void enterUserCredentialsAndSignIn() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../Task1/data.properties");
		prop.load(fis);
		String emailAddress=prop.getProperty("existingUserEmail");
		userEmailAddress.sendKeys(emailAddress);
		String userPassword=prop.getProperty("existingUserPassword");
		password.sendKeys(userPassword);
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
