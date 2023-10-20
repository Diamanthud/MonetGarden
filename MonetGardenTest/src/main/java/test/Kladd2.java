package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions.IsVisibleOptions;
import com.microsoft.playwright.options.AriaRole;

import pages.MonetGardenImgPage;
import testbase.TestBase;

public class Kladd2 extends TestBase {

	@Test
	public void testAcceptCookies() {
		
		
		
		String homeUrl = "http://uitestingplayground.com/progressbar";
		page.navigate(homeUrl);
	     // Wait for the progress bar to reach 75%
        page.waitForSelector(".progress-bar[aria-valuenow='75']");

        // Click the "Start" button
        page.locator("button:has-text('Start')").click();

        // Wait for the progress bar to reach 100%
        page.waitForSelector(".progress-bar[aria-valuenow='100']");

        // Click the "Stop" button
        page.locator("button:has-text('Stop')").click();

}}


