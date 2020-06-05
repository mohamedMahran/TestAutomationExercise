package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.WebDriverFacade;

public class Header {
	private WebDriverFacade webDriver;
	
	public Header(WebDriverFacade webDriver) {
	        this.webDriver = webDriver;
	    }
	private WebElement getSignOutButton()
	{
		return webDriver.findElement(By.xpath("//a[@title='Log me out']"));
	}
	private WebElement getSignInButton()
	{
		return webDriver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
	}

	public void signOut()
	{
	
		getSignOutButton().click();
	}

	public void signIn()
	{
	
		this.getSignInButton().click();
	
	}
	
}
