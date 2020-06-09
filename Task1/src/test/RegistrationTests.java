package tests;

import java.io.IOException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pages.header.HeaderPage;
import pages.landing.LandingPage;
import pages.login.LoginPage;
import pages.registration.Register;
import utilis.ExtentTestManager;

public class RegistrationTests extends BaseTest {

	@Test(dataProvider = "accountInformation")
	
	public void validateNewAccount(String firstName, String surName, String passwod,String company, String days, String month,
			String year,  String address1, String address2, String city, String state, String postcode,
			String other, String phone, String mobilePhone, String alias)
			throws  IOException {
		try {
			LoginPage loginPage = LoginPage.getLoginPage();
			HeaderPage header =   HeaderPage.getHeaderPage();
			LandingPage landing = LandingPage.getLandingPage();
			Register register= Register.getRegisterPage();

			header.step().signIn();
			loginPage.step().enterNewAccount();
			loginPage.step().clickOnCreateAccountButton();
			
			register.step().enterPersonalData(firstName, surName, passwod, company)
						   .selectDates(days,month,year)
						   .enterAddress(address1, address2, city)
						   .selectState(state)
						   .enterContacts(postcode, other, phone, mobilePhone, alias)
						   .submit();
			
			
			landing.check().headerText("MY ACCOUNT").
							fullName(firstName + " " + surName).
							accountInfo("Welcome to your account. Here you can manage all of your personal information and orders.");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.INFO, ExceptionUtils.getStackTrace(e));
		}

	}

	@DataProvider(name = "accountInformation")
	public Object[][] accountInformation() {
		return new Object[][] { { "Firstname", "Lastname", "Qwerty","Company", 
								   "10","10", "2000",
								   "Qwerty, 123","zxcvb","1", 
								   "1", 
								   "12345", "Qwerty", "12345123123", "12345123123", "hf" } };
	}

}
