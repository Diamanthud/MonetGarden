package pages;

import com.microsoft.playwright.Page;

import pagebase.PageBase;

public class HomePage extends PageBase {

	Page page;

	public HomePage(Page page) {
		this.page = page;

	}

	public void OpenHomePage() {
		String homeUrl = "https://monets-garden.se/";
		page.navigate(homeUrl);

	}

	public void login(String userName, String password) {
		// usernameInput.fill(userName);
		// passwordInput.fill(password);

	}
}