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
		homePage.OpenHomePage();
	
		

	}
	}

