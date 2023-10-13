package testbase;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import javax.print.attribute.standard.PagesPerMinute;

import com.microsoft.playwright.Locator;

public class CookieHandler {
	private Page page;
	private Locator acceptCookies;
	private boolean wasClicked;

	public CookieHandler(Page page) {
		this.page = page;
		wasClicked = false;
	}

	public boolean acceptCookiesIfVisible() {
		acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar"));
		wasClicked = false;

		if (acceptCookies.isVisible()) {
			acceptCookies.click();
			System.out.println("| Cookies Accepted |");
			wasClicked = true;
		} else {
			System.out.println("| Cookies Not Accepted |");
		}
		return wasClicked;
	}
}
