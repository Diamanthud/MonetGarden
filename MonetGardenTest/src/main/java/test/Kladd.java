/*
 * 
 *    	SUPER KLADD
 * 
 * 
 */

package test;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByTextOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;

import pagebase.PageBase;
import pages.HomePage;
import testbase.CookieHandler;
import testbase.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Kladd extends TestBase{
	
	@Test
	void NuTestarVi () {
		// Navigation
		HomePage homePage = new HomePage(page);
		CookieHandler cookieHandler = new CookieHandler(page);

		homePage.OpenHomePage();
		cookieHandler.acceptCookiesIfVisible();	
	     
	     page.locator(".Carousel_dots__K6YZr").click();
	     page.locator(".Carousel_dots__K6YZr > button:nth-child(2)").click();
	     page.locator(".Carousel_dots__K6YZr > button:nth-child(3)").click();
	     page.locator("button:nth-child(4)").first().click();
	     page.locator("button:nth-child(5)").click();
	     page.locator(".Carousel_dot__WUXF2").first().click();

	}
	}