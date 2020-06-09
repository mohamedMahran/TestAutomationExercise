package pages.menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import core.Driver;
import utilis.ExtentTestManager;
import utilis.Helper;

public class MainMenu {


	private List<WebElement> getMenuItems()
	{
		return Driver.findElements(By.cssSelector("#block_top_menu > ul > li > a "));
	}
	private List<WebElement> getWomenProducts()
	{
		return Driver.findElements(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/a | // *[@id='block_top_menu']/ul/li[1]/ul/li[2]/a"));
	}
	private List<WebElement> getDressProducts()
	{
		return Driver.findElements(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li"));
	}
	private List<WebElement> getTshitProducts()
	{
		return Driver.findElements(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"));
	}

	public List<String> getMainMenuItems()
	{
		return Helper.getListOfStringsFromListOfElements( getMenuItems());
	}
	public  void selectCategoryFromMenu(String category) 
	{
	
	List<WebElement> menuItems =  getMenuItems();

	for (WebElement menu : menuItems) {

		if (category.equalsIgnoreCase(menu.getText()))
		{
			menu.click();
			break;
		}
	}

}
	public void hoverOnTheMainMenu(String product) 
	{
		int count = 0;
		for (WebElement Element : getMenuItems()) {
			count = count + 1;
			String link = Element.getAttribute("title");
			if(link.equalsIgnoreCase(product))
				try {
					Helper.hoverOn(Element);
				} catch (Exception e) {

					ExtentTestManager.getTest().log(Status.FAIL, e.getMessage());
				}
			
		}
	}
	public int getCountOfProductItemsOf(String product) {

		switch(product)
		{
		case "WOMEN":
			return getWomenProducts().size();
			
		case "DRESSES":
			return getDressProducts().size();
		case "T-shirts":
			return getTshitProducts().size();
		default:
			break;
		}
		return 0;
		
	}
	public void verifyProductListContainsWomanAndDressesAndTshirt()
	{
		List<String> actualProductList = getMainMenuItems();
		
		Assert.assertTrue(actualProductList.contains("WOMEN"));
		Assert.assertTrue(actualProductList.contains("DRESSES"));
		Assert.assertTrue(actualProductList.contains("T-SHIRTS"));
		
	}
}