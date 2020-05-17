package automationPracticeTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bsh.ParseException;
import core.WebDriverFacade;
import junit.framework.Assert;
import pages.MainMenu;
import utilis.ExcelLib;

public class MenuTests extends BaseTest {
	
	//WebDriver webDriver = WebDriverFacade.getWebDriver();
	@Test(dataProvider="menuItems")
	public void testCountsOfProductListForEachMainProduct(String mainProduct,String actualCount)
	{
	
		MainMenu menu = new MainMenu(webDriver);
		menu.hoverOnTheMainMenu(mainProduct);
		int expectedCountOfMainProduct = menu.getCountOfProductItemsOf(mainProduct);
		int actualCountOfMainProduct = Integer.parseInt(actualCount);
		Assert.assertEquals(expectedCountOfMainProduct, actualCountOfMainProduct);
		
	}
	@DataProvider(name="menuItems")
	public Object[][] checkOut() throws ParseException, IOException, java.text.ParseException
	{
		String[][] array = ExcelLib.getExcelData("../Task1/Data.xlsx", "menuItems");
		return array;
	}

}
