package org.cart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import core.WebDriverFacade;

public class Order {
	private WebDriverFacade webDriver;
	

	private WebElement getPayByBankWireButton()
	{
		return webDriver.findElement(By.xpath("//a[@title='Pay by bank wire']"));
	}
	private WebElement getProcessAddressButton()
	{
		return webDriver.findElement(By.xpath("//button[@name='processAddress']"));
	}
	private WebElement getLastStepLabel()
	{
		return webDriver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']"));
	}
	private WebElement getOrderIsCompleteTextField()
	{
		return webDriver.findElement(By.xpath("//*[@class='cheque-indent']/strong"));
	}
	private WebElement getProceedToTheCheckoutButton()
	{
		return webDriver.findElement(By.xpath(" //button[@name='processCarrier']"));
	}
	private WebElement getconfirmMyOrderButton()
	{
		return webDriver.findElement(By.cssSelector("#cart_navigation > button"));
	}
	public Order(WebDriverFacade driver)
	{
		this.webDriver=driver;
	}
	public String getTextOfOrderIsComplete()
	{
		
		return getOrderIsCompleteTextField().getText();
		
	}
	public void confirmMyOrder()
	{
		this.getconfirmMyOrderButton().click();
	}

	public void proceedToTheCheckOut()
	{		
		getProceedToTheCheckoutButton().click();
	}
	public void clickByTermOfService() {

		 webDriver.findElement(By.xpath("//div[@class='checker']")).click();
	}
	public void payByBankWire()
	{
		getPayByBankWireButton().click();
	}
	public void processAddress() {

		getProcessAddressButton().click();
	}
	public boolean isCurrentpageLastStepOfOrder()
	{
		try
		{
			return getLastStepLabel().isDisplayed();
		}
		catch(ElementNotVisibleException envm)
		{
			System.out.println(envm.getStackTrace());
		}
		return false;
	}
}
