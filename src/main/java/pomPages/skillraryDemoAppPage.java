package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.webDriverUtility;

public class skillraryDemoAppPage {

	// Declaration
	@FindBy(xpath = "//a[@class=\"navbar-brand\"]")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[text()='COURSE']")
	private WebElement courseTab;

	@FindBy(xpath = "//span//a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;

	@FindBy(xpath = "//select[@name=\"addresstype\"]")
	private WebElement categoryDropDown;

	@FindBy(xpath = "//a[text()='Contact Us']")
	private WebElement contactUsLink;

	// Intialization
	public skillraryDemoAppPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getpageHeader() {
		return pageHeader.getText();
	}

	public void mouseHoverToCourse(webDriverUtility web) {

		web.mouseHover(courseTab);
	}

	public void clickseleniumTrainingLink() {
		seleniumTrainingLink.click();
	}

	public void selectTestingInCetegory(webDriverUtility web, int index) {
		web.dropDown(categoryDropDown, index);
	}

	public WebElement scrollcontactUsLink() {
		return contactUsLink;
	}

	public void clickcontactUsLink() {
		contactUsLink.click();
	}

}
