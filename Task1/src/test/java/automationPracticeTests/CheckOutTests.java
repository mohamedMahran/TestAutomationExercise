package automationPracticeTests;

import static org.testng.Assert.assertTrue;
import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import bsh.ParseException;
import utilis.ExcelLib;
import utilis.ExtentTestManager;

public class CheckOutTests extends BaseTest{
	Logger log = Logger.getLogger(RegistrationTests.class);

	@Test(dataProvider="checkOut")
	public void validateCheckoutProcess(String productName,String size,String testCaseName) throws IOException 
	{
		try
		{

			log.info("1. Log in as existing customer");
		
			homePage.signIn();

			loginPage.enterUserCredentialsAndSignIn();
		
			log.info("2. Click *Women* button in the header");
		
			landing.selectCategoryFromMenu("WOMEN");
		
			log.info("3. Click the product with name Faded Short Sleeve T-shirts");
		
			//landing.clickOnProduct("Faded Short Sleeve T-shirts");
			landing.clickOnProduct(productName);
			
			landing.selectSize(size);
			
			log.info("4. Click *Add to card*");
		
			landing.clickOnAddToCartButton();
		
			log.info("5. Click *Proceed to checkout*");
		
			landing.clickOn("6. Proceed to checkout");
		
			log.info("7. Click *Proceed to checkout*");
		
			landing.proceedToCheckOut();
		
			log.info("8. Click *Proceed to checkout*");
		
			landing.checkout();
		
			log.info("9. Click by *Terms of service* to agree");
			
			landing.clickByTermOfService();
		
			log.info("10. Click *Proceed to checkout*");
		
			landing.checkout();
		
			log.info("11. Click by payment method *Pay by bank wire");
		
			landing.payByBankWire();
		
			log.info("12. Click *I confirm my order*");
		
			landing.confirmMyOrder();
		
		// Assertions
		// Order confirmation page(?controller=order-confirmation) is opened
			assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
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
		String[][] array = ExcelLib.getExcelData("../Task1/Data.xlsx", "checkout","enter the name of dress, size  in the checkout test");
		return array;
	}

}
