package TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseClass;

public class Test3 extends BaseClass {

	@Test
	public void test3() {
		SoftAssert soft = new SoftAssert();

		home.getsearchTestField("core java for selenium");

		soft.assertTrue(coreHome.getpageHeader().isDisplayed());
		coreHome.clickcoreJavaForSeleniumCourseLink();
		soft.assertTrue(coreTraining.getpageHeader().isDisplayed());

		coreTraining.clickplayButton();

		coreTraining.clickaddToWishListLink();
		soft.assertAll();
	}

}
