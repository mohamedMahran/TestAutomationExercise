package org.tests;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import core.WebDriverFacade;
import utilis.ReadPropertisFile;
public class BaseTest  {
	    

	static WebDriverFacade webDriver;
	static String url = null;
	static Logger log = Logger.getLogger(BaseTest.class);
	
	@Parameters("browser")
	  @BeforeClass
	    public static void setUp(String browser) {
			try {
				
				url = ReadPropertisFile.getURL();
			} catch (IOException e) {
				log.info("Error in url",e);
				
			}
	        
			webDriver = new WebDriverFacade(browser);
	        webDriver.start(url);
	        webDriver.maximize();
	    }
		

	 @AfterClass
	 public void tearDown( )  {
		
		 webDriver.destoryDriver();
	 }

}
