package pages;

import com.microsoft.playwright.Page;

import testbase.TestBase;

public class LoadDelayPage extends TestBase {
	Page page;

	public LoadDelayPage(Page page) {
		this.page = page;

	}

	public void LoadDelayPage1() {
		String homeUrl = "https://uitestingplayground.com/loaddelay";
		page.navigate(homeUrl);

	}

	public void LoadDelayPage2() {
		String homeUrl = "https://uitestingplayground.com/";
		page.navigate(homeUrl);
	}
}
