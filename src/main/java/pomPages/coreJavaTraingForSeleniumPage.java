package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.webDriverUtility;

public class coreJavaTraingForSeleniumPage {
	// Declaration
	@FindBy(xpath = "//img[@alt=\"SkillRary\"]")
	private WebElement pageHeader;

	@FindBy(xpath = "//button[@aria-label=\"Play\"]")
	private WebElement playButton;

	@FindBy(xpath = "//span[text()='Add To Wishlist']")
	private WebElement addToWishListLink;

	// Initialization
	public coreJavaTraingForSeleniumPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public WebElement getpageHeader() {
		return pageHeader;
	}

	public void clickplayButton() {
		playButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		playButton.click();
	}

	public void clickaddToWishListLink() {
		addToWishListLink.click();
	}

}
