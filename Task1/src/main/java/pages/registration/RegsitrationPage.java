package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import core.DriverSingleTone;


public class RegsitrationPage {

	private WebElement firstName=DriverSingleTone.findElement(By.id("customer_firstname"));
	private WebElement surName=DriverSingleTone.findElement(By.id("customer_lastname"));
	private WebElement password = DriverSingleTone.findElement(By.id("passwd"));
	private WebElement day = DriverSingleTone.findElement(By.id("days"));
	Select dayList = new Select(day);
	private WebElement month = DriverSingleTone.findElement(By.id("month"));
	Select monthList = new Select(month);
	private WebElement year = DriverSingleTone.findElement(By.id("year"));
	Select yearList = new Select(year);
	private WebElement company = DriverSingleTone.findElement(By.id("company"));
	private WebElement address1 = DriverSingleTone.findElement(By.id("address1"));
	private WebElement address2 = DriverSingleTone.findElement(By.id("address2"));
	private WebElement city = DriverSingleTone.findElement(By.id("city"));
	private WebElement state = DriverSingleTone.findElement(By.id("state"));
	Select stateList = new Select(state);
	private WebElement postcode = DriverSingleTone.findElement(By.id("postcode"));
	private WebElement other = DriverSingleTone.findElement(By.id("other"));
	private WebElement phone = DriverSingleTone.findElement(By.id("phone"));
	private WebElement phoneMobile = DriverSingleTone.findElement(By.id("phone_mobile"));
	private WebElement submitAccount = DriverSingleTone.findElement(By.id("submitAccount"));
	private WebElement hf = DriverSingleTone.findElement(By.id("alias"));


	public void enterNewAccount(String firstName,String surName,String passwod,String days,String month,String year,String company,
			String Address1,String Address2,String city,String state,String postcode,String other,String phone,String mobilePhone,String alias)
	{
		 
		 this.firstName.sendKeys(firstName);
		 this.surName.sendKeys(surName);
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
         this.phoneMobile.sendKeys(mobilePhone);
         this.hf.sendKeys(alias);
	}
	public void submit()
	{
		this.submitAccount.click();
	}


	
}
