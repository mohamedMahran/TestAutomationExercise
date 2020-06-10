	package pages.product;
	
	import java.util.ArrayList;
	import java.util.List;
	
	import org.openqa.selenium.By;
	
	import core.Driver;
	import core.WebTable;
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
		public ProductVerifyController rowCount() throws Exception
		{
			WebTable w = new WebTable(Driver.findElement(By.xpath("//table")));
			Assert.assertEquals(2, w.getRowCount());
			return this;
		}
		public ProductVerifyController columnCount()
		{
			WebTable w = new WebTable(Driver.findElement(By.xpath("//table")));
			Assert.assertEquals(2, w.getColumnCount());
			return this;
		}
		public ProductVerifyController columnName()
		{
			WebTable w = new WebTable(Driver.findElement(By.xpath("//table")));
			List<String> actualColumns = w.columnData(1);
			List<String>  expectedColumns = new ArrayList<>();  
			expectedColumns.add("Compositions");
			expectedColumns.add("Styles");
			expectedColumns.add("Properties");
			Assert.assertTrue(actualColumns.equals(expectedColumns));
			return this;
		}
			
		public 	ProductVerifyController rowDetails() throws Exception
		{
			WebTable w = new WebTable(Driver.findElement(By.xpath("//table")));
			List<String> actualRows = w.rowData(1);
			ArrayList<String> expectedRows = new ArrayList<>();
			expectedRows.add("Styles");
			expectedRows.add("Casual");
			Assert.assertTrue(actualRows.equals(expectedRows));
			Assert.assertTrue(w.presenceOfData("Compositions"));
			Assert.assertTrue(w.getCellData(2, 2).contains("Short Sleeve"));
			return this;
		}
		public ProductVerifyController allData()
		{
			WebTable w = new WebTable(Driver.findElement(By.xpath("//table")));
			List<String> actualData=w.getAllData();
			Assert.assertTrue(actualData.contains("Properties"));
			return this;
		}
	
	}
