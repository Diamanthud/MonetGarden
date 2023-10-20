package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import testbase.TestBase;

public class SampleAppPage extends TestBase {

	Page page;

	String user;
	String loginStatusText;

	Locator usernameInput;
	Locator loginButton;
	Locator logoutButton;
	Locator passwordField;

	public SampleAppPage(Page page) {
		this.page = page;
		this.usernameInput = page.getByPlaceholder("User name");
		this.passwordField = page.getByPlaceholder("********");
		this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
	}

	public void openPage() {
		String loginUrl = "http://uitestingplayground.com/sampleapp/";
		page.navigate(loginUrl);
	}

	public void login(String userName, String pwd) {
		usernameInput.fill(userName);
		passwordField.fill(pwd);
		loginButton.click();
	}

	public boolean isLoginStatusContains(String expectedText) {
		page.waitForSelector("#loginstatus");
		loginStatusText = page.querySelector("#loginstatus").textContent();
		return loginStatusText.contains(expectedText);
	}

	public String getUsernameInputValue() {
		usernameInput = page.getByPlaceholder("User name");
		return usernameInput.inputValue();
	}

}