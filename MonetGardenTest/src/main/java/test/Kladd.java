/*
 * 
 *    	SUPER KLADD
 * 
 * 
 */

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.validator.PublicClassValidator;

import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByTextOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;

import pagebase.PageBase;
import pages.HomePage;
import pages.LoginPage;
import pages.MonetsGardenPage;
import testbase.CookieHandler;
import testbase.TestBase;
import pages.TextInputPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Kladd extends TestBase {

	@Test
	public void test() {
		
	    CookieHandler cookieHandler = new CookieHandler(page);
	    cookieHandler.acceptCookiesIfVisible();
	}}