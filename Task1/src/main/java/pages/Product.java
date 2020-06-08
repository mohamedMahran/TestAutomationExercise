package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import core.DriverSingleTone;
import utilis.ExtentTestManager;
import utilis.Helper;


public class Product {
	

	public Product enterQuantity(String quantity) {
		DriverSingleTone.findElement(By.cssSelector("#quantity_wanted")).clear();
		DriverSingleTone.findElement(By.cssSelector("#quantity_wanted")).sendKeys(quantity);
		return this;
	}

	public Product selectSize(String requiredSize) {
		if (!DriverSingleTone.findElements(By.xpath("//fieldset[1]/div/div/select")).isEmpty()) {
			List<WebElement> dropdownlist = DriverSingleTone.findElements(By.xpath("//fieldset[1]/div/div/select"));
			for (WebElement e : dropdownlist) {
				if (e.getText().contains(requiredSize)) {
					Select size = new Select(e);
					size.selectByVisibleText(requiredSize);
				}
			}

		}
		return this;
	}

	public void addToCart() {
		DriverSingleTone.findElement(By.id("add_to_cart")).click();
		Helper.waitTillVisibilityofElement(By.xpath("//div[@class='button-container']"), 10);
		
	}

	public void click(String button) {

		try {

			Helper.clickOn(DriverSingleTone.findElements(By.xpath("//div[@class='button-container']")), button);
		} catch (Exception ex) {
			ExtentTestManager.getTest().log(Status.FAIL,ex);
		}

	}

	public List<String> getColorsOfTheProduct() {
		return Helper.getListOfStringsFromListOfElements(DriverSingleTone.findElements(By.xpath("//ul[@id='color_to_pick_list']")));
	}

	public List<String> getCountOfSocialSharingProduct() {
		return Helper.getListOfStringsFromListOfElements(DriverSingleTone.findElements(By.xpath("//p[@class='socialsharing_product list-inline no-print']")));
	}
}
