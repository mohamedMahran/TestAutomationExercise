package utilis;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {
	public static Properties prop;
	public static String createNewEmail()
	{
		 String timestamp = String.valueOf(new Date().getTime());
		 //generating random values for email address
		 String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
		 return email;
	}
	public static void takeScreenShot(WebDriver driver,String result) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		String currentDir = System.getProperty("user.dir");
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + result + timeStamp + ".png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static void loadFromPropertiesFile() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../Test/data.properties");
		prop.load(fis);
	}
}
