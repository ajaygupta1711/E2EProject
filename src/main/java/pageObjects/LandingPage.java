package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='listbuilder-popup-scale']//button[contains(text(), 'NO THANKS')]") WebElement jonpopup;
	@FindBy(xpath="//span[contains(text(), 'Login')]") WebElement loginlink;
	@FindBy(css="section[id='content'] h2") WebElement featuredcourses; // .text-center>h2 - new way to identify the webelement
	@FindBy(css="[class='navbar-collapse collapse'] li") WebElement navigationbar;
	
	public WebElement jonpopup()
	{
		return jonpopup;
	}
	
	public WebElement loginlink()
	{
		return loginlink;
	}
	
	public WebElement featuredcourses()
	{
		return featuredcourses;
	}
	
	public WebElement navigationbar()
	{
		return navigationbar;
	}
}