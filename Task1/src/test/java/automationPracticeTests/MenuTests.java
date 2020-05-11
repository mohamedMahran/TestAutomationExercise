package automationPracticeTests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Core.Driver;
import bsh.ParseException;
import junit.framework.Assert;
import pageObjects.MainMenu;
import utilis.ExcelLib;

public class MenuTests extends BaseTest {
	
	
	@Test(dataProvider="menuItems")
	public void testCountsOfProductListForEachMainProduct(String mainProduct,String actualCount)
	{
	
		MainMenu menu = new MainMenu(Driver._browser);
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
