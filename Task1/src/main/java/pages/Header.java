package pages;

import org.openqa.selenium.By;


import core.DriverSingleTone;

public class Header {
	
	public void signOut()
	{
		DriverSingleTone.findElement(By.xpath("//a[@title='Log me out']")).click();
	}

	public void signIn()
	{
		DriverSingleTone.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
	}
	
}
