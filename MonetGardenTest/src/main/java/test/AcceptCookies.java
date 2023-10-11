package test;

import org.junit.jupiter.api.Test;

import pages.HomePage;
import testbase.TestBase;

public class AcceptCookies extends TestBase {

	@Test
	void TestHomePage() {

		HomePage homePage = new HomePage(page);

		homePage.acceptCookiesIfVisible();

	}
}
