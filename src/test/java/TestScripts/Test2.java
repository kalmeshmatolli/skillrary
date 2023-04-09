package TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseClass;
import pomPages.homePage;

public class Test2 extends BaseClass {

	@Test
	public void test2() {
		SoftAssert soft = new SoftAssert();
		home.clickgearsTab();
		home.clickskillraryDemoAppLink();
		web.handleChildBrowser();
		soft.assertEquals(skillrary.getpageHeader(), "SkillRary-ECommerce");
		skillrary.selectTestingInCetegory(web, 1);
		soft.assertEquals(testing.getpageHeader(), "SkillRary-ECommerce");
		web.dragAndDrop(testing.getseleniumTrainingImage(), testing.getcartArea());
		web.scrollTillElemet(testing.getfacebookIconLink());
		testing.clickfacebookIconLink();
		soft.assertAll();

	}

}
