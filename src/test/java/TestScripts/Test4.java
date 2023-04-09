package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseClass;

public class Test4 extends BaseClass {

	@Test
	public void test4() {
		SoftAssert soft = new SoftAssert();
		home.clickgearsTab();
		home.clickskillraryDemoAppLink();
		web.handleChildBrowser();
		soft.assertEquals(skillrary.getpageHeader(), "SkillRary-ECommerce");
		web.scrollTillElemet(skillrary.scrollcontactUsLink());
		skillrary.clickcontactUsLink();
		soft.assertTrue(contact.getcontactUsIcon().isDisplayed());

		Map<String, String> map = excel.readData("Sheet1");
		contact.sendContactInfo(map.get("Full Name"), map.get("Email"), map.get("Subject"), map.get("message"));
		contact.clicksendUsMailButton();
		soft.assertAll();

	}

}
