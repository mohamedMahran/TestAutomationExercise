package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.Helper;
import core.WebDriverFacade;

public class Product {
	private WebDriverFacade webDriver;
	private WebElement getQuantityField()
	{
		return webDriver.findElement(By.cssSelector("#quantity_wanted"));
	}
	private WebElement getAddToCartButton()
	{
		return webDriver.findElement(By.id("add_to_cart"));
	}
	private List<WebElement> getColorsToPick()
	{
		return webDriver.findElements(By.xpath("//ul[@id='color_to_pick_list']"));
	}

	private List<WebElement> getButtonsInTheLayerCart()
	{
		return webDriver.findElements(By.xpath("//div[@class='button-container']"));
	}
	private List<WebElement> getSocialSharingProduct()
	{
		return webDriver.findElements(By.xpath("//p[@class='socialsharing_product list-inline no-print']"));
	}
 	public Product(WebDriverFacade driver) {
		this.webDriver=driver;
	}
 	public void enterQuantity(String quantity)
 	{
 		getQuantityField().clear();
 		getQuantityField().sendKeys(quantity);
 	}
	public void selectSize(String requiredSize) 
	{
				if(webDriver.findElements(By.xpath("//fieldset[1]/div/div/select")).size() > 0)
				{
					List<WebElement> dropdownlist = webDriver.findElements(By.xpath("//fieldset[1]/div/div/select"));
					for (WebElement e : dropdownlist) 
					{
						if(e.getText().contains(requiredSize))
						{
							Select size = new Select(e);
							size.selectByVisibleText(requiredSize);
						}
					}

				}
				
	}
	public void addToCart()
	{
		getAddToCartButton().click();
	}
	public void click(String button) {
		
		try
		{
		Helper.clickOn(getButtonsInTheLayerCart(), button);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getStackTrace());
		}
		
	}
	public List<String> getColorsOfTheProduct()
	{
		return Helper.getListOfStringsFromListOfElements(getColorsToPick());
	}
	public List<String> getCountOfSocialSharingProduct()
	{
		return Helper.getListOfStringsFromListOfElements(getSocialSharingProduct());
	}
}
