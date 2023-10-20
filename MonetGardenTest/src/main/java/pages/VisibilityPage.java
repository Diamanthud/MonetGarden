package pages;

import com.microsoft.playwright.Page;

import testbase.TestBase;

public class VisibilityPage extends TestBase {
	Page page;

	public VisibilityPage(Page page) {
		this.page = page;

	}

	public void OpenPage() {
		String homeUrl = "https://uitestingplayground.com/visibility";
		page.navigate(homeUrl);

	}

}
