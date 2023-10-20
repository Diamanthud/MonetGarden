package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions.IsVisibleOptions;
import com.microsoft.playwright.options.AriaRole;

import pages.HomePage;
import testbase.CookieHandler2;
import testbase.TestBase;

public class Kladd2 extends TestBase {

	@Test
	public void testAcceptCookies() {
		
		HomePage homePage = new HomePage(page);
		homePage.MonetHomePage();

	
		// Check if cookies are disabled using the button and actual cookies
		boolean cookiesDisabled = isCookiesDisabled() && !areCookiesSet();

		if (cookiesDisabled) {
			System.out.println("Cookies are disabled.");
		} else {
			System.out.println("Cookies are enabled.");
		}
	}


	private boolean isCookiesDisabled() {
		var acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar"));

// Return true if the button is not visible (indicating cookies are accepted)
		return !acceptCookies.isVisible();
	}

	private boolean areCookiesSet() {
// Retrieve and check actual cookies from the page
		var cookies = page.context().cookies();

// Return true if cookies are not set (indicating cookies are disabled)
		return cookies.isEmpty();
	}

}


