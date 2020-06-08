package pages.login;

import java.io.IOException;
import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;
import core.DriverSingleTone;
import utilis.ExtentTestManager;
import utilis.Helper;
import utilis.ReadPropertisFile;


public class LoginPage   {
	
	private String username;
	private String password;
	private String submit;
	private String signIn;
	private String emailAddress;
	
	public LoginPage()
	{
	try 
		{
		 username = Helper.load("automationpractice.login.user.id");
		 password= Helper.load("automationpractice.login.password.id");
		 submit=Helper.load("automationpractice.login.submitCreate.id");
		 signIn=Helper.load("automationpractice.login.singIn.xpath");
		 emailAddress=Helper.load("automationpractice.login.createEmail.id");
		} 
	catch (IOException e) 
		{
			ExtentTestManager.getTest().log(Status.FAIL, e.getMessage());
		}
	}
	public LoginPage enterUserEmailAddress()
	{
		String email = null;
		try {
			email = ReadPropertisFile.getExistingUserEmail();
		} catch (IOException e) {

			ExtentTestManager.getTest().log(Status.FAIL,e);
		}
		DriverSingleTone.findElement(By.id(username)).sendKeys(email);
		return this;
	}
	public LoginPage enterPassword() throws IOException
	{
		String userPassword = null;
		userPassword = ReadPropertisFile.getExistingPassword();
		DriverSingleTone.findElement(By.id(password)).sendKeys(userPassword);
		return this;
	}
	public void signIn()
	{
		DriverSingleTone.findElement(By.xpath(signIn)).click();
	}
	public void enterNewAccount()
	{
		
		DriverSingleTone.findElement(By.id(emailAddress)).sendKeys(Helper.getNewEmail());
		
	}
	public void clickOnCreateAccountButton() {
		
		DriverSingleTone.findElement(By.id(submit)).click();

	}


}
