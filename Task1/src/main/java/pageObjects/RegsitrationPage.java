package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegsitrationPage  {
	public WebDriver driver;
	
	@FindBy(id = "customer_firstname")
	private WebElement firstname;
	
	@FindBy(id = "customer_lastname")
	private WebElement surname;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "days")
	private WebElement day;
	
	@FindBy(id = "months")
	private WebElement month;
	
	@FindBy(id ="years")
	private WebElement year;
	
	@FindBy(id ="company")
	private WebElement company;
	
	@FindBy(id ="address1")
	private WebElement address1;
	
	@FindBy(id ="address2")
	private WebElement address2;
	
	@FindBy(id ="city")
	private WebElement city;
	
	@FindBy(id ="id_state")
	private WebElement state;
	
	@FindBy(id ="postcode")
	private WebElement postcode;
	
	@FindBy(id ="other")
	private WebElement other;
	
	@FindBy(id ="phone")
	private WebElement phone;
	
	@FindBy(id ="phone_mobile")
	private WebElement phone_mobile;
	
	@FindBy(id ="alias")
	private WebElement hf;
	
	@FindBy(id ="submitAccount")
	private WebElement submitAccount;
	
	
	public RegsitrationPage(WebDriver driver)
	{
		if (driver != null) {

			PageFactory.initElements(driver, this);

		} else {
			try {
				throw new Exception("Driver doesn't instintiated");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void enterNewAccount(String firstName,String surName,String passwod,String days,String month,String year,String company,
			String Address1,String Address2,String city,String state,String postcode,String other,String phone,String mobilePhone,String alias)
	{
		this.firstname.sendKeys(firstName);  
		this.surname.sendKeys(surName);
        this.password.sendKeys(passwod);
        
        Select dayList = new Select(this.day);
        dayList.selectByValue(days);
        
        Select monthList = new Select(this.month);
        monthList.selectByValue(month);
        
        Select yearList = new Select(this.year);
        yearList.selectByValue(year);
        
        this.company.sendKeys(company);
        
        this.address1.sendKeys(Address1);
        
        this.address2.sendKeys(Address2);
        
        this.city.sendKeys(city);
        
        Select stateList = new Select(this.state);
        stateList.selectByVisibleText(state);
        
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
