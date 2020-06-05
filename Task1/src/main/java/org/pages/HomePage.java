package org.pages;

import org.apache.log4j.Logger;
import core.WebDriverFacade;


public class HomePage  {
	
	
	private WebDriverFacade webDriver;
	Logger log = Logger.getLogger(HomePage.class);	
	public HomePage(WebDriverFacade webDriver) {
	        this.webDriver = webDriver;
	    }
	

}
