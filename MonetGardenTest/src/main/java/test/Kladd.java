/*
 * 
 *    	SUPER KLADD
 * 
 * 
 */

package test;

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
import testbase.CookieHandler;
import testbase.TestBase;
import pages.TextInputPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Kladd extends TestBase {


	 
	   @Test
	    public void CarouselButtonandImage() {
		   HomePage homePage = new HomePage(page);
		   
		   homePage.MonetHomePage();

		   page.waitForSelector(".keen-slider");
	        page.waitForSelector("img[src*='mg20.jpg']");

	        String[] imageUrls = { "mg20.jpg", "mg9.jpg", "monets-garten-wien-c-philipplipiarski_03.jpg", "mg27.jpg", "mg25.jpg" };

	        homePage.clickPreviousButton(5);
	        for (String imageUrl : imageUrls) {
	            boolean isImagePresent = homePage.isImagePresent(imageUrl);
	            Assertions.assertTrue(isImagePresent, "Image " + imageUrl + " is not present in the carousel");
	        }

	        homePage.clickNextButton(5);
	 


}}
