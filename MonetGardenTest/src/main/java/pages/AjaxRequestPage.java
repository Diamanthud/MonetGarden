package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import testbase.TestBase;

public class AjaxRequestPage extends TestBase {
	Page page;

	Locator ajaxButton;

	public AjaxRequestPage(Page page) {
		this.page = page;
		this.ajaxButton = page.locator("#ajaxButton");
	}

	public void openPage() {
		String homeUrl = "http://uitestingplayground.com/ajax";
		page.navigate(homeUrl);
	}

	public void PressandWait() {
		ajaxButton.click();
		page.waitForSelector("p.bg-success:has-text(\"Data loaded with AJAX get request\")");

	}

}