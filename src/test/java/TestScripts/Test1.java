package TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseClass;

public class Test1 extends BaseClass {

	@Test
	public void test1() {
		SoftAssert soft = new SoftAssert();
		home.clickgearsTab();
		home.clickskillraryDemoAppLink();
		web.handleChildBrowser();

		soft.assertEquals(skillrary.getpageHeader(), "SkillRary-ECommerce");

		skillrary.mouseHoverToCourse(web);
		skillrary.clickseleniumTrainingLink();

		soft.assertEquals(selenium.getpageHeader(), "SkillRary-ECommerce");

		selenium.doubleClickAdd(web);
		selenium.clickaddToCart();

		selenium.handleAlert(web);
		soft.assertEquals(selenium.getitemAddedToCartMessage(), "Item added to cart");

		soft.assertAll();

	}

}
