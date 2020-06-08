package pages.order;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;


import core.DriverSingleTone;

public class OrderVerifyController {
	

	
	public OrderVerifyController verifyOrderConfirmationPageIsDisplayedSuccessfully()
	{
		// Order confirmation page(?controller=order-confirmation) is opened
			assertTrue(DriverSingleTone.getCurrentUrl().contains("controller=order-confirmation"));
			return this;
								
	}

	public OrderVerifyController verifyOrderIsComplete()
	{
		// The order is complete.
		assertTrue(DriverSingleTone.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains("Your order on My Store is complete."));
		return this;

		
	}
	
	public OrderVerifyController verifyCurrentPageIsLastStepOfOrdering()
	{
		// Current page is the last step of ordering
		assertTrue(DriverSingleTone.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
		return this;
	}

}
