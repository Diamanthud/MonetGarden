package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import pages.HomePage;
import pages.MonetsGardenPage;
import testbase.CookieHandler;
import testbase.TestBase;

public class AcceptCookies extends TestBase {

	@Test
	public void testAcceptCookies() {

		HomePage homePage = new HomePage(page);

		homePage.MonetHomePage();

	}

}
