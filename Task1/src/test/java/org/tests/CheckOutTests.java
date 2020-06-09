package org.tests;

import java.io.IOException;
import org.apache.log4j.Logger;
import pages.login.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import bsh.ParseException;
import pages.header.Header;
import pages.landing.LandingPage;
import pages.menu.MainMenu;
import pages.product.Product;
import pages.order.OrderPage;
import pages.summary.Summary;
import utilis.ExcelLib;
import utilis.ExtentTestManager;

public class CheckOutTests extends BaseTest {

	@Test(dataProvider = "checkOut")
	public void validateCheckoutProcess(String productName, String size)   {
		try {

			Logger log = Logger.getLogger(CheckOutTests.class);
			LoginPage loginPage = LoginPage.getLoginPage();
			MainMenu menu = new MainMenu();
			LandingPage landing = LandingPage.getLandingPage();
			OrderPage order = OrderPage.getOrderPage();
			Product product = new Product();
			Header header = new Header();
			Summary summary = new Summary();
			
			
			log.info("1. Log in as existing customer");
			header.signIn();
			ExtentTestManager.getTest().log(Status.INFO, " 1. Log in as existing customer");
			log.info("2. Click *Women* button in the header");
			loginPage.step().enterUserEmailAddress()
					 		.enterPassword()
					 		.signIn();
			
			ExtentTestManager.getTest().log(Status.INFO, " 2. Click *Women* button in the header");		
			menu.selectCategoryFromMenu("WOMEN");
			menu.verifyProductListContainsWomanAndDressesAndTshirt();
			
			log.info("3. Click the product with name Faded Short Sleeve T-shirts");
			landing.check().fullName("Joe Black")
			   			   .headerText("WOMEN")
			   			   .logOutAvailable();
			landing.step().clickOnProduct(productName);
			ExtentTestManager.getTest().log(Status.INFO, " 3. Click the product with name Faded Short Sleeve T-shirts");
			
			log.info("4. Select Size,Enter Quantity then click add to cart");
			product.enterQuantity("5")
				   .selectSize(size)
				   .addToCart();
			log.info("5. Click *Proceed to checkout*");
			product.click("Proceed to checkout");
			ExtentTestManager.getTest().log(Status.INFO, " 6. Click *Proceed to checkout*");
			
			log.info("7. Click *Proceed to checkout*");
			summary.proceedToCheckOut();
			ExtentTestManager.getTest().log(Status.INFO, " 7. Click *Proceed to checkout*");
			
		
			log.info("8. Process Address,Click By term Of Service,Proceed to checkout then confirm the order*");
			order.step()
					.processAddress()
					.clickByTermOfService()
					.proceedToTheCheckOut()
					.payByBankWire()
					.confirmMyOrder();
			ExtentTestManager.getTest().log(Status.INFO, " 8. Process Address,Click By term Of Service,Proceed to checkout then confirm the order*");

			order.check()
				 	.verifyOrderConfirmationPageIsDisplayedSuccessfully()
				 	.verifyOrderIsComplete()
				 	.verifyCurrentPageIsLastStepOfOrdering();
			
			log.info("9. Sign out ");
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
