package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	// Declaration
	@FindBy(xpath = "//img[@alt=\"SkillRary\"]")
	private WebElement logo;

	@FindBy(xpath = "//a[text() = ' GEARS ']")
	private WebElement gearsTab;

	@FindBy(xpath = "//ul[@class=\"dropdown-menu gear_menu\"]//a[text()=' SkillRary Demo APP']")
	private WebElement skillraryDemoAppLink;

	@FindBy(xpath = "//input[@placeholder=\"Search for Courses\"]")
	private WebElement searchTestField;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement searchButton;

	// Initialization
	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getlogo() {
		return logo;
	}

	public void clickgearsTab() {
		gearsTab.click();
	}

	public void clickskillraryDemoAppLink() {
		skillraryDemoAppLink.click();
	}

	public void getsearchTestField(String searchValue) {
		searchTestField.sendKeys(searchValue);
		searchButton.click();
	}
	
	

}
