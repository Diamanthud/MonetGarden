package testbase;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Locator;

public class CookieHandler {
	private Page page;
	private String url;

	public CookieHandler(Page page) {
		this.page = page;
		this.url = "https://monets-garden.se/";
	}

	public void acceptCookiesIfVisible() {
		Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar"));

		if (acceptCookies.isVisible()) {
			acceptCookies.click();
			System.out.println("| Cookies Accepted |");
		} else
			System.out.println("| Cookies Not Accepted |");
	}

	// Getter för Page
	public Page getPage() {
		return page;
	}

	// Setter för Page
	public void setPage(Page page) {
		this.page = page;
	}

	// Getter för URL
	public String getUrl() {
		return url;
	}

	// Setter för URL
	public void setUrl(String url) {
		this.url = url;
	}
}
