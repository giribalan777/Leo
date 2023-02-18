package pompackages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreJavaVideoPage {
	//Declaration
	@FindBy(xpath="//h1")
	private WebElement pageHeader;
	
	@FindBy(xpath="//button[@aria-label='Play']")
	private WebElement playButton;
	
	@FindBy(xpath="//button[@aria-label='Pause']")
	private WebElement pauseButton;
	
	@FindBy(xpath="//span[text()='Add to WishList']")
	private WebElement addToWishlistTab;
	
	@FindBy(xpath="//a[@class='class_cookies']")
	private WebElement closeCookiesIcon;
	
	//Initialization
	public CoreJavaVideoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	public void clickPlayButton()
	{
		playButton.click();
	}
	
	public void clickPauseButton()
	{
		pauseButton.click();
	}
	
	public void clickAddToWishlist()
	{
		addToWishlistTab.click();
	}
	
	public void clickCloseCookies()
	{
		closeCookiesIcon.click();
	}
}