package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By jonpopup = By.xpath("//div[@class='listbuilder-popup-scale']//button[contains(text(), 'NO THANKS')]");
	By loginlink = By.xpath("//span[contains(text(), 'Login')]");
	By featuredcourses = By.cssSelector("section[id='content'] h2"); // .text-center>h2 - new way to identify the webelement
	By navigationbar = By.cssSelector("[class='navbar-collapse collapse'] li");
	
	public LoginPage jonpopup()
	{
		driver.findElement(jonpopup).click();
		LoginPage popup = new LoginPage(driver);
		return popup;
	}
	
	public LoginPage loginlink()
	{
		driver.findElement(loginlink).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	public WebElement featuredcourses()
	{
		return driver.findElement(featuredcourses);
	}
	
	public WebElement navigationbar()
	{
		return driver.findElement(navigationbar);
	}
	
}