package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {
	public WebDriver driver;
	
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
	
	@FindBy(css="#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium ")
	private WebElement chckOut1;
	
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

	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
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
	public boolean isCurrentpageLastStepOfOrder()
	{
		return lastStep.isDisplayed();
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
		chckOut1.click();
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
		return logout.isDisplayed();
	}
	
	public  void selectCategoryFromMenu(String category) 
		{
		
		List<WebElement> menuItems =  BasePage.driver.findElements(By.cssSelector("#block_top_menu > ul > li  > a"));

		for (WebElement menu : menuItems) {

			if (category.equalsIgnoreCase(menu.getText()))

				menu.click();
				break;
		}

	}
	public void clickOnProduct(String item) {
		// TODO Auto-generated method stub
		List<WebElement> products =  BasePage.driver.findElements(By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a"));

		for (WebElement product : products) {

			if (item.equals(product.getText()))

				product.click();
				break;
		}
	}
	
	public void clickOn(String button) {
		// TODO Auto-generated method stub
		List<WebElement> buttons =  BasePage.driver.findElements(By.cssSelector("div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container"));

		for (WebElement btn : buttons) {

			if (button.contains(btn.getText()))

				btn.click();
				break;
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
}
