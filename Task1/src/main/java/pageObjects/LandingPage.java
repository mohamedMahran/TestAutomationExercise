package pageObjects;

import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import Core.BasePage;
import Core.Helper;

public class LandingPage extends BasePage {
	
	
	@FindBy(className = "account")
	private WebElement fullname;
	
	@FindBy(css = "h1")
	private WebElement heading;
	
	@FindBy(className = "info-account")
	private WebElement accountInfo;
	
	@FindBy(className = "logout")
	private WebElement logout;
	
	@FindBy(id="add_to_cart")
	private WebElement addToCart;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement _proceedToCheckOut;
	
	@FindBy(xpath="//p//a[@title='Proceed to checkout']")
	private WebElement _proceed;
	
	@FindBy(css=" p > button")
	private WebElement checkOut;
	
	@FindBy(css="#cgv")
	private WebElement termOfConditionCheckBox;
	
	@FindBy(css="#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
	private WebElement payByBankWire;
	
	@FindBy(css="#cart_navigation > button")
	private WebElement confirmMyOrder;
	
	@FindBy(xpath="//*[@class='cheque-indent']/strong")
	private WebElement orderIsComplete;
	
	@FindBy(xpath="//li[@id='step_end' and @class='step_current last']")
	private WebElement lastStep;
	
	@FindBy(id ="group_1")
	private WebElement size;
	
	@FindBy(css="#center_column > ul > li > div > div.right-block > h5 > a")
	private List<WebElement> productList;
	
	@FindBy(css="div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container")
	private List<WebElement> buttonsCartList;

	@FindBy(xpath="//button[@name='processAddress']")
	private WebElement processAddress;

	
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		
	}
	public boolean isCurrentpageLastStepOfOrder()
	{
		try
		{
			return lastStep.isDisplayed();
		}
		catch(ElementNotVisibleException envm)
		{
			System.out.println(envm.getStackTrace());
		}
		return false;
	}
	public String getTextOfOrderIsComplete()
	{
		
			return orderIsComplete.getText();
		
	}
	public void confirmMyOrder()
	{
		this.confirmMyOrder.click();
	}
	public void proceedToCheckOut()
	{
		_proceedToCheckOut.click();
	}
	public void proceedToTheCheckOut()
	{
		_proceed.click();
	}
	public void checkout()
	{
		checkOut.click();
	}
	public void clickOnAddToCartButton()
	{
		addToCart.click();
	}
	public String getFullName()
	{
		return fullname.getText();
	}
	public String getHeaderText()
	{
		return heading.getText();
	}
	public String getAccountInfo()
	{
		return accountInfo.getText();
	}
	public boolean doesLogOutAvailable()
	{
		try
		{
			return logout.isDisplayed();	
		}
		catch(ElementNotVisibleException envm)
		{
			System.out.println(envm.getStackTrace());
		}
		return false;
	}
	public void clickOnProduct(String item) {
		// TODO Auto-generated method stub
		List<WebElement> products =  productList;

		for (WebElement product : products) {

			if (item.equals(product.getAttribute("title")))

				product.click();
				break;
		}
	}
	public void clickOn(String button) {
		// TODO Auto-generated method stub
		//Helper.wait_Till_Visibility_of_List_Element(this.buttonsCartList, 5);
		try
		{
		Helper.clickOn(this.buttonsCartList, button);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getStackTrace());
		}
		
	}
	
	
	public void clickByTermOfService() {
		// TODO Auto-generated method stub
		this.termOfConditionCheckBox.click();
	}
	public void payByBankWire()
	{
		this.payByBankWire.click();
	}
	public void selectSize(String requiredSize) {
		// TODO Auto-generated method stub
		Select sizeList = new Select(this.size);
        sizeList.selectByVisibleText(requiredSize);
		
	}
	public void processAddress() {
		// TODO Auto-generated method stub
		this.processAddress.click();
	}
}
