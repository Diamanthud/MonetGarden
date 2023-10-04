package automationcamp;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import base.PageBase;

public class LoginPage extends PageBase {
	Page page;
	
	Locator usernameInput;
	Locator passwordInput;
	Locator loginButton;
	Locator rememberMeCheckBox;
	

	public LoginPage(Page page) {
		this.usernameInput = page.getByPlaceholder("Username");
		this.passwordInput = page.getByPlaceholder("Password");
		this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
		this.rememberMeCheckBox = page.getByPlaceholder("Remember me");
	}

	public void openLoginPage() {
		String loginUrl = "https://play1.automationcamp.ir/login.html";
		page.navigate(loginUrl);
	}

	public void login(String userName, String password) {
		usernameInput.fill(userName);
		passwordInput.fill(password);
		loginButton.click();
	}

}