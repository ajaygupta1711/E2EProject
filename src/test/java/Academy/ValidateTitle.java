package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base {
	
	public WebDriver driver;

	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());  
	
		@BeforeTest
		public void initialize() throws IOException
		{
			driver=initializeDriver();
			log.info("Driver is initialized");
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			log.info("Navigated to Home page");
		}
	
		@Test
		public void validateAppTitle() throws IOException
		{
			LandingPage lp = new LandingPage(driver);
			
			lp.jonpopup().click();
			
			Assert.assertEquals(lp.featuredcourses().getText(), "FEATURED COURSES123");
	
			// Compare the text from the browser with actual test - ERROR..
			Assert.assertTrue(lp.navigationbar().isDisplayed());
			log.info("Successfully validated Text message");
			System.out.println("Test Completed");
		}
		
		
		@AfterTest
		public void  teardown()
		{
			driver.close();
		}
		
}