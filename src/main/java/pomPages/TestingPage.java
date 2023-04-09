package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingPage {

	// Declaration
	@FindBy(xpath = "//a[@class=\"navbar-brand\"]")
	private WebElement pageHeader;

	@FindBy(xpath = "//img[@id=\"Selenium Training\"]")
	private WebElement seleniumTrainingImage;

	@FindBy(xpath = "//div[@id=\"cartArea\"]")
	private WebElement cartArea;

	@FindBy(xpath = "//li/descendant::i[@class=\"fa fa-facebook\"]")
	private WebElement facebookIconLink;

	// Initialization
	public TestingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public String getpageHeader() {
		return pageHeader.getText();
	}

	public WebElement getseleniumTrainingImage() {
		return seleniumTrainingImage;
	}

	public WebElement getcartArea() {
		return cartArea;
	}

	public WebElement getfacebookIconLink() {
		return facebookIconLink;
	}

	public void clickfacebookIconLink() {
		facebookIconLink.click();
	}

}
