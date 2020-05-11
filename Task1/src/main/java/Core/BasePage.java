package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public   WebDriver driver;

	
	public BasePage(WebDriver driver)
	{
		  this.driver=driver;
		  if (driver != null) {

				PageFactory.initElements(driver, this);

			} else {
				try {
					throw new Exception("Driver doesn't instintiated");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	

}
