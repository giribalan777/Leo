package pompackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.WebDriverUtility;

public class skillraryDemoAppPage {
	
	//Declaration
	@FindBy(xpath="//div[@class='navbar-header']")
	private WebElement pageHeader;
	@FindBy(id="course")
	private WebElement courseTab;
	@FindBy(xpath="//span[@class='wrappers']/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;
	@FindBy(name="addresstype")
	private WebElement categoryDropdown;
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactUsLink;
	
	//Initialization
	public skillraryDemoAppPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getPageHeader()
	{
		return pageHeader;
	}
	
	public void mouseHoverToCourse(WebDriverUtility web)
	{
		web.mouseHover(courseTab);
	}
	
	public void clickSeleniumTraining()
	{
		seleniumTrainingLink.click();
	}
	
	public void selectCategory(WebDriverUtility web, int index)
	{
		web.dropdown(categoryDropdown, index);
	}
	
	public WebElement getContactUs()
	{
		return contactUsLink;
	}
	public void clickContactUs()
	{
		contactUsLink.click();
	}
}
