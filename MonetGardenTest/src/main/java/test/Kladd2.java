package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.lang.model.element.Element;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions.IsVisibleOptions;
import com.microsoft.playwright.options.AriaRole;

import pages.MonetGardenImgPage;
import testbase.TestBase;

public class Kladd2 extends TestBase {

	@Test
	public void testAcceptCookies() {
		this.page = page;

		String homeUrl = "http://uitestingplayground.com/progressbar";
		page.navigate(homeUrl);

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
		page.waitForFunction("parseInt(document.querySelector('.progress-bar[aria-valuenow]').style.width) >= 75",
				null);

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Stop")).click();

		int resultElementCount = page.locator("#result").count();

		if (resultElementCount > 0) {
			String resultText = page.locator("#result").first().textContent();
			System.out.println("RÄTT");
			Assertions.assertTrue(resultText.contains("Result:"));
		} else {
			System.out.println("FEL");

		}
	}
}