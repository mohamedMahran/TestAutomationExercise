package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.WebDriverFacade;

public class RegsitrationPage {
	
	private WebDriverFacade webDriver;
	private WebElement getFirstName()
	{
		return webDriver.findElement(By.id("customer_firstname"));
	}
	private WebElement getSurname()
	{
		return webDriver.findElement(By.id("customer_lastname"));
	}

	private WebElement password = webDriver.findElement(By.id("passwd"));
	private WebElement day = webDriver.findElement(By.id("days"));
	Select dayList = new Select(day);
	private WebElement month = webDriver.findElement(By.id("month"));
	Select monthList = new Select(month);
	private WebElement year = webDriver.findElement(By.id("year"));
	Select yearList = new Select(year);
	private WebElement company = webDriver.findElement(By.id("company"));
	private WebElement address1 = webDriver.findElement(By.id("address1"));
	private WebElement address2 = webDriver.findElement(By.id("address2"));
	private WebElement city = webDriver.findElement(By.id("city"));
	private WebElement state = webDriver.findElement(By.id("state"));
	Select stateList = new Select(state);
	private WebElement postcode = webDriver.findElement(By.id("postcode"));
	private WebElement other = webDriver.findElement(By.id("other"));
	private WebElement phone = webDriver.findElement(By.id("phone"));
	private WebElement phone_mobile = webDriver.findElement(By.id("phone_mobile"));
	private WebElement submitAccount = webDriver.findElement(By.id("submitAccount"));
	private WebElement hf = webDriver.findElement(By.id("alias"));
	


	public RegsitrationPage(WebDriverFacade webDriver) {
		this.webDriver=webDriver;
	}
	


	public void enterNewAccount(String firstName,String surName,String passwod,String days,String month,String year,String company,
			String Address1,String Address2,String city,String state,String postcode,String other,String phone,String mobilePhone,String alias)
	{
		 
		getFirstName().sendKeys(firstName);
		getSurname().sendKeys(surName);
		this.password.sendKeys(passwod);
		this.dayList.selectByValue(days);
		this.monthList.selectByValue(month);
		this.yearList.selectByValue(year);
        this.company.sendKeys(company);
        this.address1.sendKeys(Address1);
        this.address2.sendKeys(Address2);
         this.city.sendKeys(city);
         this.stateList.selectByVisibleText(state);
         this.postcode.sendKeys(postcode);
         this.other.sendKeys(other);
         this.phone.sendKeys(phone);
         this.phone_mobile.sendKeys(mobilePhone);
         this.hf.sendKeys(alias);
	}
	public void submit()
	{
		this.submitAccount.click();
	}


	
}
