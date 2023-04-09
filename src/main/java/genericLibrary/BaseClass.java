package genericLibrary;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pomPages.TestingPage;
import pomPages.contactUsPage;
import pomPages.coreJavaSeleniumHome;
import pomPages.coreJavaTraingForSeleniumPage;
import pomPages.homePage;
import pomPages.seleniumTrainingPage;
import pomPages.skillraryDemoAppPage;

public class BaseClass {

	protected ExcelFileUtility excel;
	protected javaUtility javaUtil;
	protected propertyFileUtility property;
	protected webDriverUtility web;
	protected WebDriver driver;
	protected homePage home;
	protected skillraryDemoAppPage skillrary;
	protected seleniumTrainingPage selenium;
	protected coreJavaSeleniumHome coreHome;
	protected coreJavaTraingForSeleniumPage coreTraining;
	protected TestingPage testing;
	protected contactUsPage contact;

//	@BeforeSuite
//	@BeforeTest

	@BeforeClass
	public void classConfiger() {
		web = new webDriverUtility();
		property = new propertyFileUtility();
		javaUtil = new javaUtility();
		excel = new ExcelFileUtility();

		property.propertyConfg(IconstantPath.PROPERTY_FILE);
		String browser = property.fetchProperty("browser");
		String url = property.fetchProperty("url");
		long time = Long.parseLong(property.fetchProperty("time"));
		driver = web.openApplication(browser, url, time);

	}

	@BeforeMethod
	public void methodConfiger() {
		excel.ExcelInitialization(IconstantPath.EXCEL_FILE);

		home = new homePage(driver);
		skillrary = new skillraryDemoAppPage(driver);
		selenium = new seleniumTrainingPage(driver);
		coreHome = new coreJavaSeleniumHome(driver);
		coreTraining = new coreJavaTraingForSeleniumPage(driver);
		testing = new TestingPage(driver);
		contact = new contactUsPage(driver);

		Assert.assertTrue(home.getlogo().isDisplayed());
	}

	@AfterMethod
	public void methodTearDown() {
		excel.closeWorkbook();
	}

	@AfterClass

	public void classTearDown() {
		web.quiteBrowser();
	}

//	@AfterTest
//	@AfterSuite

}
