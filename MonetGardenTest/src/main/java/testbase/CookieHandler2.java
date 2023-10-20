package testbase;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CookieHandler2 {
    private Page page;
    private Locator acceptCookies;

    public CookieHandler2(Page page) {
        this.page = page;
    }

    public void acceptCookiesIfVisible() {
        acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar"));

        if (acceptCookies.isVisible()) {
            acceptCookies.click();
            System.out.println("Cookies accepted");
        } else {
            assertCookiesNotAccepted();
        }
    }

    private void assertCookiesAccepted() {
        assertTrue acceptCookies;

    }

    private void assertCookiesNotAccepted() {
        assert !acceptCookies.isVisible() : "Cookies Not Accepted";
    }
}