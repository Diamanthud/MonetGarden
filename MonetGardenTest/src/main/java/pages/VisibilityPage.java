package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import testbase.TestBase;

public class VisibilityPage extends TestBase {
	Page page;

	Locator hideButton;

	public VisibilityPage(Page page) {
		this.page = page;
		this.hideButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hide"));

	}

	public void OpenPage() {
		String homeUrl = "http://uitestingplayground.com/visibility";
		page.navigate(homeUrl);
	}

	public void ClickonHideButton() {
		hideButton.click();
	}

}
