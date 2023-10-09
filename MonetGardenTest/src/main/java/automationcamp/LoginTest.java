package automationcamp;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import automationcamp.LoginPage;
import base.TestBase;

public class LoginTest extends TestBase {

	@Test
	void loginAsAdmin() {

		LoginPage loginPage = new LoginPage(page);
		
		loginPage.openLoginPage();
		loginPage.login("admin", "admin");

		assertThat(page).hasTitle("Order Pizza");
	}

	@Test
	void failedLogin() {

		LoginPage loginPage = new LoginPage(page);

		loginPage.openLoginPage();
		loginPage.login("abc", "abc");

	}
	}
