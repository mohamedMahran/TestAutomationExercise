package utilis;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bsh.ParseException;

public class ExcelLib {

	public static String[][] getExcelData(String fileName, String sheetName, String testCaseName)
			throws IOException, ParseException, java.text.ParseException {

		FileInputStream fs = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sh = wb.getSheet(sheetName);
		int totalNoOfCols = sh.getRow(0).getLastCellNum();
		int totalNoOfRows = sh.getLastRowNum();
		String[][] data = new String[1][totalNoOfCols];
		XSSFCell cell = null;
		DataFormatter formatter = new DataFormatter();

		// Loop through all rows in the sheet
		// Start at row 1 as row 0 is our header row
		int k = 0;
		for (int i = 1; i <= totalNoOfRows - 1; i++) {
			XSSFRow row = sh.getRow(i);
			boolean isExist = false;

			for (int j = 0; j < totalNoOfCols; j++) {
				cell = row.getCell(j);
				if (cell.getStringCellValue().equalsIgnoreCase(testCaseName) &&cell.getStringCellValue()!=null) {
					isExist = true;
					String value = formatter.formatCellValue(cell);
					data[k][j] = value;

				} else if(cell.getStringCellValue()!=null){
					String value = formatter.formatCellValue(cell);
					data[k][j] = value;
				}
				else
					continue;

			}
			if (isExist ) {
				fs.close();
				break;
				
			}
			
		}

		
		return data;

	}

}