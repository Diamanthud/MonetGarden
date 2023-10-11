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
		boolean isNotAccepted = true; // Börjar med antagandet att knappen inte har klickats

		if (acceptCookies.isVisible()) {
		    acceptCookies.click();
		    System.out.println("| Cookies Accepted |");
		    isNotAccepted = false; // Uppdatera variabeln om knappen klickades
		} else {
		    System.out.println("| Cookies Not Accepted |");
		}

	

}}