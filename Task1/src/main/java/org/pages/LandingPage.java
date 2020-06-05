package org.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import core.WebDriverFacade;
import utilis.Helper;

public class LandingPage   {
	

	
	private WebDriverFacade webDriver;

	private WebElement getFullNameText()
	{
		return webDriver.findElement(By.className("account"));
	}
	private WebElement getHeader()
	{
		return webDriver.findElement(By.cssSelector("h1"));
	}
	private WebElement getAccontInfoText()
	{
		return webDriver.findElement(By.className("info-account"));
	}
	private WebElement getLogoutLink()
	{
		return webDriver.findElement(By.className("logout"));
	}
	private List<WebElement> getProductListContainer()
	{
		return webDriver.findElements(By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a"));
	}
	

	public LandingPage(WebDriverFacade driver) {
		this.webDriver=driver;
	}


	
	public String getFullName()
	{
		return getFullNameText().getText();
	}
	
	public String getHeaderText()
	{
		return getHeader().getText();
	}
	
	public String getAccountInfo()
	{

		return getAccontInfoText().getText();

	}
	
	public boolean doesLogOutAvailable()
	{
		
			return getLogoutLink().isDisplayed();	
		
	}

	public void clickOnProduct(String item) {

		try
		{
		Helper.clickOn(getProductListContainer(), item);
		}

		catch(Exception ex)
		{
			System.out.println(ex.getStackTrace());
		}
	}
	






}
