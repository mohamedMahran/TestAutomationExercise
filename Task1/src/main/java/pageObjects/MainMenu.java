package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Core.BasePage;
import Core.Helper;

public class MainMenu extends BasePage{
	@FindBy(css = "#block_top_menu > ul > li > a ")
	private List<WebElement> _menu;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/a | // *[@id='block_top_menu']/ul/li[1]/ul/li[2]/a")
	private List<WebElement> _womenCategories;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/ul/li")
	private List<WebElement> _dressCategories;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
	private List<WebElement> _TSHIRTCategories;
	
	public MainMenu(WebDriver driver)
	{
		super(driver);
	}
	public List<String> getMainMenuItems()
	{
		return Helper.getListOfStringsFromListOfElements( _menu);
	}
	public  void selectCategoryFromMenu(String category) 
	{
	
	List<WebElement> menuItems =  _menu;

	for (WebElement menu : menuItems) {

		if (category.equalsIgnoreCase(menu.getText()))

			menu.click();
			break;
	}

}
	public void hoverOnTheMainMenu(String product) {
		// TODO Auto-generated method stub
		int count = 0;
		for (WebElement Element : _menu) {
			count = count + 1;
			String link = Element.getAttribute("title");
			if(link.equalsIgnoreCase(product))
				try {
					Helper.HoverOn(Element);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
	public int getCountOfProductItemsOf(String product) {
		// TODO Auto-generated method stub
		switch(product)
		{
		case "WOMEN":
			return _womenCategories.size();
			
		case "DRESSES":
			return _dressCategories.size();
		case "T-shirts":
			return _TSHIRTCategories.size();
		
		}
		return 0;
		
	}
}
