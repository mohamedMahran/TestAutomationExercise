package org.cart.pages;

import org.openqa.selenium.By;

import core.WebDriverFacade;

public class Summary {
	private WebDriverFacade webDriver;

	public Summary(WebDriverFacade driver)
	{
		this.webDriver=driver;
	}
	public void proceedToCheckOut()
	{
		webDriver.findElement(By.xpath("//p[@class='cart_navigation clearfix'] //a[@title='Proceed to checkout'] ")).click();
	}

}
