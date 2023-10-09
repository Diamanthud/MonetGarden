package test;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;

import pages.HomePage;
import testbase.CookieHandler;
import testbase.TestBase;

public class AcceptCookies extends TestBase {

	@Test
	void TestHomePage() {

		HomePage homePage = new HomePage(page);
		CookieHandler cookieHandler = new CookieHandler(page);

		homePage.OpenHomePage();
		cookieHandler.acceptCookiesIfVisible();	
		
	}
}
