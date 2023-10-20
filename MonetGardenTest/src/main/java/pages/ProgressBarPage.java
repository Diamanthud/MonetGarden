package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;

public class ProgressBarPage {
	Page page;

	public ProgressBarPage(Page page) {
		this.page = page;

	}

	public void LoadDelayPage1() {
		String homeUrl = "https://uitestingplayground.com/progressbar";
		page.navigate(homeUrl);
	     // Wait for the progress bar to reach 75%
        page.waitForSelector(".progress-bar[aria-valuenow='75']");

        // Click the "Start" button
        page.locator("button:has-text('Start')").click();

        // Wait for the progress bar to reach 100%
        page.waitForSelector(".progress-bar[aria-valuenow='100']");

        // Click the "Stop" button
        page.locator("button:has-text('Stop')").click();
    }


	}


