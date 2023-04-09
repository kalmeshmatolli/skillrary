package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactUsPage {
	
	//Declaration
	@FindBy(xpath = "//div[@class=\"breadcrumb-c\"]//img[@class=\"lazy\"]")
	private WebElement contactUsIcon;
	
	@FindBy(xpath = "//input[@placeholder=\"Full Name\"]")
	private WebElement fullNameTF;
	
	@FindBy(xpath = "//input[@placeholder=\"Email\"]")
	private WebElement emailTF;
	
	@FindBy(xpath = "//input[@placeholder=\"Subject\"]")
	private WebElement subjectTF;
	
	@FindBy(xpath = "//textarea[@placeholder=\"Message\"]")
	private WebElement messageTextArea;
	
	@FindBy(xpath = "//button[text()='Send us mail']")
	private WebElement sendUsMailButton;
	
	//Initialization
	public contactUsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getcontactUsIcon()
	{
		return contactUsIcon;
	}
	
	public void sendContactInfo(String fullname, String email, String subject, String message)
	{
		fullNameTF.sendKeys(fullname);
		emailTF.sendKeys(email);
		subjectTF.sendKeys(subject);
		messageTextArea.sendKeys(message);
	}
	
	public void clicksendUsMailButton()
	{
		sendUsMailButton.click();
	}
	
}
