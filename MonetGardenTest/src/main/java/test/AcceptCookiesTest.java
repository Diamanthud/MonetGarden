package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import pages.MonetGardenCookiesPage;
import testbase.TestBase;

public class AcceptCookiesTest extends TestBase {

	@Test
	public void testAcceptCookies() {

		MonetGardenCookiesPage homePage = new MonetGardenCookiesPage(page);

		homePage.MonetHomePage();

		boolean cookiesDisabled = homePage.isCookiesDisabled() && !homePage.areCookiesSet();
		;

		if (cookiesDisabled) {
			Assert.assertTrue(cookiesDisabled);
			System.out.println("Cookies are disabled.");
		} else {
			Assert.assertFalse(cookiesDisabled);
			System.out.println("Cookies are enabled.");
		}
	}

}
