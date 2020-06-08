package pages;

import org.openqa.selenium.By;
import core.DriverSingleTone;
import utilis.Helper;

public class LandingPage   {

	public String getFullName()
	{
		return DriverSingleTone.findElement(By.className("account")).getText();
	}
	
	public String getHeaderText()
	{
		return DriverSingleTone.findElement(By.cssSelector("h1")).getText();
	}
	
	public String getAccountInfo()
	{

		return DriverSingleTone.findElement(By.className("info-account")).getText();

	}
	
	public boolean doesLogOutAvailable()
	{
		
			return DriverSingleTone.findElement(By.className("logout")).isDisplayed();	
		
	}

	public void clickOnProduct(String item) {

		try
		{
		Helper.clickOn(DriverSingleTone.findElements(By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a")), item);
		}

		catch(Exception ex)
		{
			System.out.println(ex.getStackTrace());
		}
	}
	






}
