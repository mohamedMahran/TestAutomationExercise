package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.Helper;
import core.WebDriverFacade;

public class MainMenu {
	private WebDriverFacade webDriver;
//	WebDriver webDriver;
//	
//	@FindBy(css = "#block_top_menu > ul > li > a ")
//	private List<WebElement> _menu;
//	
//	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/a | // *[@id='block_top_menu']/ul/li[1]/ul/li[2]/a")
//	private List<WebElement> _women;
//	
//	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/ul/li")
//	private List<WebElement> _dress;
//	
//	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
//	private List<WebElement> _tshirt;
//	

//	public MainMenu(WebDriver webDriver) {
//		this.webDriver=webDriver;
//		PageFactory.initElements(webDriver, this);
//	}
	private List<WebElement> getMenuItems()
	{
		return webDriver.findElements(By.cssSelector("#block_top_menu > ul > li > a "));
	}
	private List<WebElement> getWomenProducts()
	{
		return webDriver.findElements(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/a | // *[@id='block_top_menu']/ul/li[1]/ul/li[2]/a"));
	}
	private List<WebElement> getDressProducts()
	{
		return webDriver.findElements(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li"));
	}
	private List<WebElement> getTshitProducts()
	{
		return webDriver.findElements(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"));
	}
	
	public MainMenu(WebDriverFacade driver)
	{
		this.webDriver=driver;
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

			menu.click();
			break;
	}

}
	public void hoverOnTheMainMenu(String product) {
		// TODO Auto-generated method stub
		int count = 0;
		for (WebElement Element : getMenuItems()) {
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
			return getWomenProducts().size();
			
		case "DRESSES":
			return getDressProducts().size();
		case "T-shirts":
			return getTshitProducts().size();
		
		}
		return 0;
		
	}
}
