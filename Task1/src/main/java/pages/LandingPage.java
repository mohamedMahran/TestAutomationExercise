package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.Helper;
import core.WebDriverFacade;

public class LandingPage   {
	
//
//	WebDriver webDriver;
//	
//	@FindBy(className = "logout")
//	private WebElement logout;
//	
//	@FindBy(className = "account")
//	private WebElement _fullname;
//	
//	@FindBy(css = "h1")
//	private WebElement _heading;
//	
//	@FindBy(className = "info-account")
//	private WebElement _accountInfo;
//	
//	@FindBy(className = "logout")
//	private WebElement _logout;
//	
//	@FindBy(id="add_to_cart")
//	private WebElement _addToCart;
//	
//	@FindBy(xpath="//a[@title='Proceed to checkout']")
//	private WebElement _proceedToCheckOut;
//	
//	@FindBy(xpath="//p//a[@title='Proceed to checkout']")
//	private WebElement _proceed;
//	
//	@FindBy(css=" p > button")
//	private WebElement _checkOut;
//	
//	@FindBy(css="#cgv")
//	private WebElement _termOfConditionCheckBox;
//	
//	@FindBy(css="#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
//	private WebElement _payByBankWire;
//	
//	@FindBy(css="#cart_navigation > button")
//	private WebElement _confirmMyOrder;
//	
//	@FindBy(xpath="//*[@class='cheque-indent']/strong")
//	private WebElement _orderIsComplete;
//	
//	@FindBy(xpath="//li[@id='step_end' and @class='step_current last']")
//	private WebElement _lastStep;
//	
//	@FindBy(id ="group_1")
//	private WebElement _size;
//	
//	@FindBy(css="#center_column > ul > li > div > div.right-block > h5 > a")
//	private List<WebElement> _productList;
//	
//	@FindBy(css="div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container")
//	private List<WebElement> _buttonsCartList;
//
//	@FindBy(xpath="//button[@name='processAddress']")
//	private WebElement _processAddress;
	
//	public LandingPage(WebDriver webDriver) {
//		this.webDriver=webDriver;
//		PageFactory.initElements(webDriver, this);
//	}
	
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
		// TODO Auto-generated method stub
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
