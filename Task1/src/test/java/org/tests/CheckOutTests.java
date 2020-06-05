package org.tests;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.cart.pages.Order;
import org.cart.pages.Summary;
import org.pages.Header;
import org.pages.LandingPage;
import org.pages.LoginPage;
import org.pages.MainMenu;
import org.pages.Product;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import bsh.ParseException;
import utilis.ExcelLib;
import utilis.ExtentTestManager;
import static org.testng.Assert.assertTrue;

public class CheckOutTests extends BaseTest {

	@Test(dataProvider = "checkOut")
	public void validateCheckoutProcess(String productName, String size) throws InterruptedException {
		try {

			Logger log = Logger.getLogger(CheckOutTests.class);
			LoginPage loginPage = new LoginPage(webDriver);
			MainMenu menu = new MainMenu(webDriver);
			LandingPage landing = new LandingPage(webDriver);
			Order order = new Order(webDriver);
			Product product = new Product(webDriver);
			Header header = new Header(webDriver);
			Summary summary = new Summary(webDriver);

			
			log.info("1. Log in as existing customer");
			header.signIn();
			ExtentTestManager.getTest().log(Status.INFO, " 1. Log in as existing customer");
			
			
			log.info("2. Click *Women* button in the header");
			loginPage.enterUserCredentialsAndSignIn();
			ExtentTestManager.getTest().log(Status.INFO, " 2. Click *Women* button in the header");
			
			List<String> actualProductList = menu.getMainMenuItems();
			Assert.assertTrue(actualProductList.contains("WOMEN"));
			Assert.assertTrue(actualProductList.contains("DRESSES"));
			Assert.assertTrue(actualProductList.contains("T-SHIRTS"));
			menu.selectCategoryFromMenu("WOMEN");

			
			log.info("3. Click the product with name Faded Short Sleeve T-shirts");
			landing.clickOnProduct(productName);
			ExtentTestManager.getTest().log(Status.INFO, " 3. Click the product with name Faded Short Sleeve T-shirts");
			
			log.info("4. Select Size");
			product.selectSize(size);
			ExtentTestManager.getTest().log(Status.INFO, " 4. Select Size");

			
			product.enterQuantity("5");
			ExtentTestManager.getTest().log(Status.INFO, " 5. Enter Quantity");
			
			log.info("5. Click *Add to card*");
			product.addToCart();
			ExtentTestManager.getTest().log(Status.INFO, " 6. Click *Add to card");
			
			log.info("6. Click *Proceed to checkout*");
			product.click("Proceed to checkout");
			ExtentTestManager.getTest().log(Status.INFO, " 7. Click *Proceed to checkout*");
			
			log.info("7. Click *Proceed to checkout*");
			summary.proceedToCheckOut();
			ExtentTestManager.getTest().log(Status.INFO, " 8. Click *Proceed to checkout*");
			
		
			log.info("8. Process Address*");
			order.processAddress();
			ExtentTestManager.getTest().log(Status.INFO, " 9. Process Address*");
			
			
			log.info("9. Click by *Terms of service* to agree");
			order.clickByTermOfService();
			ExtentTestManager.getTest().log(Status.INFO, " 10. Click by *Terms of service* to agree");

			
			log.info("10. Click *Proceed to checkout*");
			order.proceedToTheCheckOut();
			ExtentTestManager.getTest().log(Status.INFO, " 11. Click *Proceed to checkout*");

			
			log.info("11. Click by payment method *Pay by bank wire");
			order.payByBankWire();
			ExtentTestManager.getTest().log(Status.INFO, " 12. Click by payment method *Pay by bank wire");

			
			log.info("12. Click *I confirm my order*");
			order.confirmMyOrder();
			ExtentTestManager.getTest().log(Status.INFO, " 13. Click *I confirm my order");

			// Assertions
			// Order confirmation page(?controller=order-confirmation) is opened
			assertTrue(webDriver.getCurrentUrl().contains("controller=order-confirmation"));
			
			// The order is complete.
			assertTrue(order.getTextOfOrderIsComplete().contains("Your order on My Store is complete."));
			// Current page is the last step of ordering
			assertTrue(order.isCurrentpageLastStepOfOrder());
			
			log.info("13. Sign out ");
			header.signOut();

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,e);
		}
	}

	@DataProvider(name = "checkOut")
	public Object[][] checkOut() throws ParseException, IOException, java.text.ParseException {
		return ExcelLib.getExcelData("../Task1/Data.xlsx", "checkout");

	}
}
