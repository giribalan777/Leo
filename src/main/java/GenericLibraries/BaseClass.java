package GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompackages.ContactUsPage;
import pompackages.CoreJavaForSeleniumPage;
import pompackages.CoreJavaVideoPage;
import pompackages.HomePage;
import pompackages.SeleniumTrainingPage;
import pompackages.TestingPage;
import pompackages.skillraryDemoAppPage;

public class BaseClass {
	
	protected PropertiesFileUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected skillraryDemoAppPage skillraryDemo;
	protected ContactUsPage contact;
	protected TestingPage testing;
	protected CoreJavaForSeleniumPage coreJava;
	protected SeleniumTrainingPage selenium;
	protected CoreJavaVideoPage javaVideo;
	protected long time;
	
	//@BeforeSuite //Suite are used for database, so we didn't use here
	//@BeforeTest //Used for parallel execution, so we didn't use here
	
	@BeforeClass //Generic Initialization and launching the browser 
	public void classConfiguration()
	{
		property=new PropertiesFileUtility();
		excel=new ExcelUtility();
		web=new WebDriverUtility();
		
		property.propertyFileInitialization(Iconstantpath.PROPERTIES_FILE_PATH);
		excel.excelInitialization(Iconstantpath.EXCEL_FILE_PATH);
	}
	
	@BeforeMethod //Used for opening and closing excel files
	public void methodConfiguration() {
		time = Long.parseLong(property.fetchproperty("timeouts"));
		driver = web.openApplication(property.fetchproperty("BROWSER"), property.fetchproperty("URL"), time);
		home=new HomePage(driver);
		
		Assert.assertTrue(home.getLogo().isDisplayed());
		
		skillraryDemo = new skillraryDemoAppPage(driver);
		selenium= new SeleniumTrainingPage(driver);
		coreJava=new CoreJavaForSeleniumPage(driver);
		javaVideo= new CoreJavaVideoPage(driver);
		testing=new TestingPage(driver);
		contact=new ContactUsPage(driver);
	}
	
	@AfterMethod
	public void methodTearDown()
    {
	   web.quitBrowser();
    }
	
	@AfterClass
	public void classTearDown()
    {
	   excel.closeExcel();
    }
	
	//@AfterTest
	//@AfterSuite
}