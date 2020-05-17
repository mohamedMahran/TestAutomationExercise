package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.Helper;
import core.WebDriverFacade;


public class LoginPage   {
	
	public static Properties prop;
	private WebDriverFacade webDriver;
//	WebDriver webDriver;
//	
//	@FindBy(id = "SubmitCreate")
//	private WebElement submitCreate;
//
//	@FindBy(id = "email_create")
//	private WebElement email;
//
//	@FindBy(xpath = "//button[@id='SubmitLogin']")
//	private WebElement signin;
//
//	@FindBy(id = "email")
//	private WebElement userEmailAddress;
//
//	@FindBy(id = "passwd")
//	private WebElement password;

//	public LoginPage(WebDriver webDriver) {
//		this.webDriver=webDriver;
//		PageFactory.initElements(webDriver, this);
//	}

//	public void enterUserCredentialsAndSignIn() throws IOException {
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream("../Task1/data.properties");
//		prop.load(fis);
//		String emailAddress=prop.getProperty("existingUserEmail");
//		userEmailAddress.sendKeys(emailAddress);
//		String userPassword=prop.getProperty("existingUserPassword");
//		password.sendKeys(userPassword);
//		signin.click();
//
//	}
	public LoginPage(WebDriverFacade driver)
	{
		this.webDriver=driver;
	}
	private WebElement getEmailAddressField()
	{
		return webDriver.findElement(By.id("email"));
	}
	private WebElement getUserPasswordField()
	{
		return webDriver.findElement(By.id("passwd"));
	}
	private WebElement getSignInButton()
	{
		return webDriver.findElement(By.xpath("//button[@id='SubmitLogin']"));
	}
	private WebElement getEmailCreateField()
	{
		return webDriver.findElement(By.id("email_create"));
	}
	private WebElement getCreateAccount()
	{
		return webDriver.findElement(By.id("SubmitCreate"));
	}
	
	public void enterUserCredentialsAndSignIn() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../Task1/data.properties");
		prop.load(fis);
		String emailAddress=prop.getProperty("existingUserEmail");
		getEmailAddressField().sendKeys(emailAddress);
		String userPassword=prop.getProperty("existingUserPassword");
		getUserPasswordField().sendKeys(userPassword);
		getSignInButton().click();

	}
	
	public void enterNewAccount()
	{
		getEmailCreateField().sendKeys(Helper.createNewEmail());
	}
	
	public void clickOnCreateAccountButton() {
		// TODO Auto-generated method stub
		getCreateAccount().click();
	}


}
