package automationPracticeTests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import bsh.ParseException;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MainMenu;
import pages.Order;
import pages.Product;
import utilis.ExcelLib;
import utilis.ExtentTestManager;

public class CheckOutTests extends BaseTest{

	Logger log = Logger.getLogger(CheckOutTests.class);
		

	@Test(dataProvider="checkOut")
	public void validateCheckoutProcess(String productName,String Size) throws InterruptedException, IOException
	{
		try
		{
			HomePage homePage = new HomePage(webDriver);
			
			LoginPage loginPage = new LoginPage(webDriver);
			
			MainMenu menu = new MainMenu(webDriver);
			
			LandingPage landing = new LandingPage(webDriver);
			
			Order order = new Order(webDriver);
			
			Product product = new Product(webDriver);
			
			log.info("1. Log in as existing customer");
			
			homePage.signIn();
			
			log.info("2. Click *Women* button in the header");
			
			loginPage.enterUserCredentialsAndSignIn();
			
			List<String> actualProductList=menu.getMainMenuItems();
			Assert.assertTrue(actualProductList.contains("WOMEN1"));
			Assert.assertTrue(actualProductList.contains("DRESSES"));
			Assert.assertTrue(actualProductList.contains("T-SHIRTS"));
			menu.selectCategoryFromMenu("WOMEN");
			
			log.info("3. Click the product with name Faded Short Sleeve T-shirts");
			
			landing.clickOnProduct(productName);
			
			log.info("4. Select Size");
			
			product.selectSize(Size);
			
			product.enterQuantity("5");
			
			log.info("5. Click *Add to card*");
			
			product.addToCart();
			
			log.info("6. Click *Proceed to checkout*");
			
			product.click("Proceed to checkout");
			
			log.info("7. Click *Proceed to checkout*");	
			
			order.proceedToCheckOut();
			
			log.info("8. Process Address*");
			
			order.processAddress();
			
			log.info("9. Click by *Terms of service* to agree");
			order.clickByTermOfService();
			
			log.info("10. Click *Proceed to checkout*");
			
			order.proceedToTheCheckOut();
			
			log.info("11. Click by payment method *Pay by bank wire");
			
			order.payByBankWire();
			
			log.info("12. Click *I confirm my order*");
			order.confirmMyOrder();
		
		// Assertions
		// Order confirmation page(?controller=order-confirmation) is opened
			assertTrue(webDriver.getCurrentUrl().contains("controller=order-confirmation"));
		// The order is complete.
			assertTrue(order.getTextOfOrderIsComplete().contains("Your order on My Store is complete."));
	    //  Current page is the last step of ordering 
			assertTrue(order.isCurrentpageLastStepOfOrder());
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(Status.INFO, ExceptionUtils.getStackTrace(e));
		
		}
	}
	@DataProvider(name="checkOut")
		public Object[][] checkOut() throws ParseException, IOException, java.text.ParseException
		{
		String[][] array = ExcelLib.getExcelData("../Task1/Data.xlsx", "checkout");
		return array;
		}
}
		




	
