package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class coreJavaSeleniumHome {

	// Declaration
	@FindBy(xpath = "//img[@alt=\"SkillRary\"]")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[contains(@href,'core-java-for-selenium-training')]//img[@class=\"thumb lazy\"]")
	private WebElement coreJavaForSeleniumCourseLink;

	// Initialization
	public coreJavaSeleniumHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getpageHeader() {
		return pageHeader;
	}

	public void clickcoreJavaForSeleniumCourseLink() {
		coreJavaForSeleniumCourseLink.click();
	}

}
