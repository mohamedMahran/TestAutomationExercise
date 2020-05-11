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

import Core.Driver;
import bsh.ParseException;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MainMenu;
import utilis.ExcelLib;
import utilis.ExtentTestManager;

public class CheckOutTests extends BaseTest{

	
	
	@Test(dataProvider="checkOut")
	public void validateCheckoutProcess(String productName,String size) throws IOException 
	{
		try
		{
			Logger log = Logger.getLogger(CheckOutTests.class);
			
			HomePage homePage = new HomePage(Driver._browser);
			
			LoginPage loginPage = new LoginPage(Driver._browser);
			
			LandingPage landing = new LandingPage(Driver._browser);
			
			MainMenu menu = new MainMenu(Driver._browser);
						
			log.info("1. Log in as existing customer");
		
			homePage.signIn();
			
			Driver.implicitWait();

			loginPage.enterUserCredentialsAndSignIn();
		
			log.info("2. Click *Women* button in the header");
			
			List<String> actualProductList=menu.getMainMenuItems();
			
			Assert.assertTrue(actualProductList.contains("WOMEN"));
			
			Assert.assertTrue(actualProductList.contains("DRESSES"));
			
			Assert.assertTrue(actualProductList.contains("T-SHIRTS"));
		
			menu.selectCategoryFromMenu("WOMEN");
		
			log.info("3. Click the product with name Faded Short Sleeve T-shirts");
		
			//landing.clickOnProduct("Faded Short Sleeve T-shirts");
			
			landing.clickOnProduct(productName);
			
			Driver.implicitWait();
			
			landing.selectSize(size);
			
			log.info("4. Click *Add to card*");
		
			landing.clickOnAddToCartButton();

			log.info("5. Click *Proceed to checkout*");
		
			Thread.sleep(1000);

			landing.clickOn("Proceed to checkout");
		
			log.info("7. Click *Proceed to checkout*");
			
			landing.proceedToTheCheckOut();
			
			log.info("8. Process Address*");
	
			landing.processAddress();
		
			log.info("9. Click by *Terms of service* to agree");
			
			Driver.implicitWait();
			
			landing.clickByTermOfService();
		
			log.info("10. Click *Proceed to checkout*");
		
			Driver.implicitWait();
			
			landing.checkout();
		
			log.info("11. Click by payment method *Pay by bank wire");
		
			landing.payByBankWire();
		
			log.info("12. Click *I confirm my order*");
		
			landing.confirmMyOrder();
		
		// Assertions
		// Order confirmation page(?controller=order-confirmation) is opened
			assertTrue(Driver.getCurrentUrl().contains("controller=order-confirmation"));
		// The order is complete.
			assertTrue(landing.getTextOfOrderIsComplete().contains("Your order on My Store is complete."));
	    //  Current page is the last step of ordering 
			assertTrue(landing.isCurrentpageLastStepOfOrder());
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
