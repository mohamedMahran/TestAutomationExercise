package org.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import core.WebDriverFacade;
import utilis.ExtentTestManager;
import utilis.Helper;
import utilis.ReadPropertisFile;


public class LoginPage   {
	
	
	private WebDriverFacade webDriver;

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
	public void enterUserEmailAddress()
	{
		String emailAddress = null;
		try {
			emailAddress = ReadPropertisFile.getExistingUserEmail();
		} catch (IOException e) {

			ExtentTestManager.getTest().log(Status.FAIL,e);
		}
		this.getEmailAddressField().sendKeys(emailAddress);
	}
	public void enterPassword() throws IOException
	{
		String userPassword = null;
		userPassword = ReadPropertisFile.getExistingPassword();
		this.getUserPasswordField().sendKeys(userPassword);
	}
	public void signIn()
	{
		getSignInButton().click();
	}
	public void enterUserCredentialsAndSignIn()  {
		try
		{
			enterUserEmailAddress();
			enterPassword();
			signIn();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(Status.FAIL,e);
		}
		
	
	}
	public void enterNewAccount()
	{
		
		getEmailCreateField().sendKeys(Helper.getNewEmail());
		
	}
	public void clickOnCreateAccountButton() {
		
		getCreateAccount().click();

	}


}
