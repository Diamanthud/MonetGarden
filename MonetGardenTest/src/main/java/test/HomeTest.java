/*
 * 
 *    	SUPER KLADD
 * 
 * 
 */

package test;

import pages.HomePage;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import testbase.CookieHandler;
import testbase.TestBase;

public class HomeTest extends TestBase {

	@Test
	void TestHomePage() {
		
		HomePage homePage = new HomePage(page);
		CookieHandler cookieHandler = new CookieHandler(page);

		homePage.OpenHomePage();
		cookieHandler.acceptCookiesIfVisible();
		
		page.click("button.Header_listButton__GUrK4");
		// Vänta på att listan med städer ska visas
		page.waitForSelector(".Header_innerList__wuB1y");
		page.click("a[href='/stockholm']");
		assertThat(page).hasURL("https://monets-garden.se/stockholm");
		page.goBack();


	}
}

