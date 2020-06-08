package pages.summary;

import org.openqa.selenium.By;
import core.DriverSingleTone;

public class Summary {
	
	public void proceedToCheckOut()
	{
		DriverSingleTone.findElement(By.xpath("//p[@class='cart_navigation clearfix'] //a[@title='Proceed to checkout'] ")).click();
	}

}
