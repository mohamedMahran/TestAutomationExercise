package pages.product;

import java.util.List;

import org.openqa.selenium.By;

import core.Driver;
import junit.framework.Assert;
import utilis.Helper;

public class ProductVerifyController {

	public ProductVerifyController colorsOfTheProduct(String [] expectedColors) {
		
		List<String> actualDisplayedColors=Helper.getListOfStringsFromElementListByAttribute(Driver.findElements(By.xpath("//ul[@id='color_to_pick_list']/li//a")),"title");
		for(int i = 0 ; i < expectedColors.length;i++)
		{
		Assert.assertEquals(expectedColors[i],actualDisplayedColors.get(i) );
		
		}
		 return this;
	}

	public ProductVerifyController countOfSocialSharingProduct() {
		 Helper.getListOfStringsFromListOfElements(Driver.findElements(By.xpath("//p[@class='socialsharing_product list-inline no-print']")));
		return this;
	}
}
