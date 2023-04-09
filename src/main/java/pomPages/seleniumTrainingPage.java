package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.webDriverUtility;

public class seleniumTrainingPage {

	// Declaration
	@FindBy(xpath = "//a[@class=\"navbar-brand\"]")
	private WebElement pageHeader;

	@FindBy(xpath = "//button[@id=\"add\"]")
	private WebElement plusButton;

	@FindBy(xpath = "//div[@class=\"input-group col-sm-5\"]/following-sibling::button[@type=\"submit\"]")
	private WebElement addToCartButton;

	@FindBy(xpath = "//span[text()='Item added to cart']")
	private WebElement itemAddedToCartMessage;

	// Initialization
	public seleniumTrainingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getpageHeader() {
		return pageHeader.getText();
	}

	public void doubleClickAdd(webDriverUtility web) {
		web.doubleClick(plusButton);
	}

	public void clickaddToCart() {
		addToCartButton.click();

	}

	public void handleAlert(webDriverUtility web) {
		web.handleAlert("ok");
	}

	public String getitemAddedToCartMessage() {
		return itemAddedToCartMessage.getText();
	}

}
