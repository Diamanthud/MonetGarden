package pages;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.Cookie;

import pagebase.PageBase;

public class MonetGardenCookiesPage extends PageBase {

	Page page;
	Locator acceptCookies;
	boolean cookiesDisabled;
	List<Cookie> cookies;

	public MonetGardenCookiesPage(Page page) {
		this.page = page;
	}

	public void MonetHomePage() {
		String homeUrl = "https://monets-garden.se";
		page.navigate(homeUrl);
	}

	public boolean isCookiesDisabled() {
		acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar"));
		acceptCookies.click();
		return !acceptCookies.isVisible();
	}

	public boolean areCookiesSet() {
		List<Cookie> cookies = page.context().cookies();
		return cookies.isEmpty();
	}
}