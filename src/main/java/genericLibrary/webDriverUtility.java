package genericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Event;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webDriverUtility {

	private WebDriver driver;
	private Actions a;
	private Select s;
	private JavascriptExecutor js;
	private Alert al;
	private Robot r;

	public WebDriver openApplication(String browser, String url, long time) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("invalid browser data");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return driver;
	}

	public WebElement explicitlyWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
		return e;
	}

	public void takesScreenShot(javaUtility currentTime) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/ss_" + currentTime.getCurrentDateTime() + ".png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mouseHover(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public void doubleClick(WebElement element) {
		a = new Actions(driver);
		a.doubleClick().perform();
	}

	public void rightClick(WebElement element) {
		a = new Actions(driver);
		a.contextClick().perform();
	}

	public void dragAndDrop(WebElement src, WebElement dest) {
		a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}

	public void dropDown(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}

	public void dropDown(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);
	}

	public void dropDown(String text, WebElement element) {
		s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(String nameorId) {
		driver.switchTo().frame(nameorId);
	}

	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}

	public void scrollTillElemet(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void handleAlert(String status) {
		al = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok")) {
			al.accept();
		} else {
			al.dismiss();
		}
	}

	public void handleChildBrowser() {

		Set<String> set = driver.getWindowHandles();
		for (String wId : set) {
			driver.switchTo().window(wId);
		}
	}

	public void closeCurrentTab() {
		driver.close();
	}

	public void quiteBrowser() {
		driver.quit();
	}

}
