package tests;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import core.Driver;
import core.WebTable;
import pages.header.Header;
import pages.landing.LandingPage;
import pages.login.LoginPage;
import pages.menu.MainMenu;
import utilis.ExtentTestManager;


public class ProductTests extends BaseTest {
	
	@Test
	public void validateDataSheet() throws Exception {
		
		LoginPage loginPage = LoginPage.getLoginPage();
		LandingPage landing = LandingPage.getLandingPage();
		Header header = new Header();
		MainMenu menu = new MainMenu();
		Logger log = Logger.getLogger(ProductTests.class);

		ExtentTestManager.getTest().log(Status.INFO, " Log in as existing customer");
		log.info("1. Log in as existing customer");
		header.signIn();

		ExtentTestManager.getTest().log(Status.INFO, " 2. Click *Women* button in the header");
		log.info("2. Click *Women* button in the header");
		loginPage.step().enterUserEmailAddress()
				 		.enterPassword()
				 		.signIn();

		ExtentTestManager.getTest().log(Status.INFO, " 3. Select Category from Menu");
		menu.selectCategoryFromMenu("WOMEN");

		ExtentTestManager.getTest().log(Status.INFO, " 4. Click the product with name Faded Short Sleeve T-shirts");
		log.info("4. Click the product with name Faded Short Sleeve T-shirts");
		landing.step().clickOnProduct("Faded Short Sleeve T-shirts");

		WebTable w = new WebTable(Driver.findElement(By.xpath("//table")));

		Assert.assertEquals(2, w.getRowCount());
		Assert.assertEquals(2, w.getColumnCount());

		List<String> actualColumns = w.columnData(1);
		List<String>  expectedColumns = new ArrayList<>();  
		expectedColumns.add("Compositions");
		expectedColumns.add("Styles");
		expectedColumns.add("Properties");
		Assert.assertTrue(actualColumns.equals(expectedColumns));

		List<String> actualRows = w.rowData(1);
		ArrayList<String> expectedRows = new ArrayList<>();
		expectedRows.add("Styles");
		expectedRows.add("Casual");
		Assert.assertTrue(actualRows.equals(expectedRows));
		Assert.assertTrue(w.presenceOfData("Compositions"));
		Assert.assertTrue(w.getCellData(2, 2).contains("Short Sleeve"));
		
		List<String> actualData=w.getAllData();
		Assert.assertTrue(actualData.contains("Properties"));

	}
}
