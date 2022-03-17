package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	public WebDriver driver;

	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());  
	
	 @BeforeTest 
	 public void initialize() throws IOException 
	 {
		driver=initializeDriver();
		driver.manage().window().maximize();
	 }
	 
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.jonpopup().click();
		l.loginlink().click();
		LoginPage lp = new LoginPage(driver); 
		lp.emailaddress().sendKeys(Username);
		lp.password().sendKeys(Password);
		lp.emailaddress().sendKeys(Username);
		lp.password().sendKeys(Password);
	//	System.out.println("text");
		log.info("text");
		lp.login().click();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{ 
		// Row stands for how many different data types test should run
		// Data Types - Restricted and Non-restricted
		// Column stands for how many values for each test
		Object[][] data = new Object[1][3];
		
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Non-Restricted User";
		
/*		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456789";
		data[1][2] = "Restricted User";   */
		
		return data;
	}

	
	@AfterTest
	public void teardown()
	{ 
		driver.close(); 
	}
 
	
}