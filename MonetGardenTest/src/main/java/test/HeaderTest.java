package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URLConnection;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByTextOptions;
import com.microsoft.playwright.options.AriaRole;

import pages.HomePage;
import testbase.CookieHandler;
import testbase.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HeaderTest extends TestBase {

	@Test
	void NavListIsCorrect() {

		// ------NAVIGATION/COOKIES-----

		HomePage homePage = new HomePage(page);
		CookieHandler cookieHandler = new CookieHandler(page);

		homePage.OpenHomePage();
		cookieHandler.acceptCookiesIfVisible();

		// ------STÄDER-----
		// Hitta och klicka på knappen "Städer"
		page.click("button.Header_listButton__GUrK4");
		// Vänta på att listan med städer ska visas
		page.waitForSelector(".Header_innerList__wuB1y");
		page.click("a[href='/stockholm']");
		assertThat(page).hasURL("https://monets-garden.se/stockholm");
		page.goBack();

		// Hitta och klicka på knappen "Städer"
		page.click("button.Header_listButton__GUrK4");
		page.waitForSelector(".Header_innerList__wuB1y");
		page.click("a[href='/malmo']");
		assertThat(page).hasURL("https://monets-garden.se/malmo");
		page.goBack();

		// ------GALLERY------
		page.click("text=Galleri");
		assertThat(page).hasURL("https://monets-garden.se/gallery");
		page.goBack();

		// ------VANLIGA FRÅGOR------
		page.click("text=Vanliga frågor");
		assertThat(page).hasURL("https://monets-garden.se/#vanliga-fragor");
		page.goBack();

		// ------KONTAKT------
		page.click("text=kontakt");
		assertThat(page).hasURL("https://monets-garden.se/#kontakt");
		page.goBack();

		// ------BILJETTER------
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Biljetter").setExact(true)).click();

		Page page1 = page.waitForPopup(() -> {
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Stockholm").setExact(true)).click();
		});
		page1.close();

		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Biljetter").setExact(true)).click();

		Page page2 = page.waitForPopup(() -> {
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Malmö").setExact(true)).click();
		});
		page2.close();

		// ------SPRÅKVAL-----
		Locator selectLocator = page.locator("#languagePicker");
		// Klicka på select-elementet för att öppna dropdown-listan
		selectLocator.click();
		// Vänta på att alternativet "en" blir synligt och klicka på det
		page.selectOption("#languagePicker", "en");

	}

}
