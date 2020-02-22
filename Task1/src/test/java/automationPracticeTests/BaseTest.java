package automationPracticeTests;
import org.testng.annotations.BeforeMethod;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.RegsitrationPage;
import pageObjects.BasePage;
public class BaseTest extends BasePage {
	    
		
	    public HomePage homePage;
	    public LoginPage loginPage;
	    public LandingPage landing;
	    RegsitrationPage registerPage ;
	    
	    @BeforeMethod
	    public void methodLevelSetup() {
	    	
	    	homePage = new HomePage(BasePage.driver);
	    	loginPage = new LoginPage(BasePage.driver);
			landing = new LandingPage(BasePage.driver);
			registerPage = new RegsitrationPage(BasePage.driver);

	    }

}
