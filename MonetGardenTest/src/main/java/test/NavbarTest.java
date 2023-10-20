package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;

import pages.MonetsGardenNavPage;
import testbase.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavbarTest extends TestBase {

	@Test
	public void testNavigation() {
		MonetsGardenNavPage monetsGardenPage = new MonetsGardenNavPage(page);

		monetsGardenPage.navToMonetsGarden();

		assertTrue("Failed to navigate to Monet's Garden", page.url().equals("https://monets-garden.se/"));

		monetsGardenPage.navigateToStockholm();
		assertThat(page).hasURL("https://monets-garden.se/stockholm");

		monetsGardenPage.navigateToMalmo();
		assertThat(page).hasURL("https://monets-garden.se/malmo");

		monetsGardenPage.navigateToGallery();
		assertThat(page).hasURL("https://monets-garden.se/gallery");

		monetsGardenPage.navigateToFAQ();
		assertThat(page).hasURL("https://monets-garden.se/#vanliga-fragor");

		monetsGardenPage.navigateToContact();
		assertThat(page).hasURL("https://monets-garden.se/#kontakt");
	}

	@Test
	public void testLanguageChange() {

		MonetsGardenNavPage monetsGardenPage = new MonetsGardenNavPage(page);

		monetsGardenPage.navToMonetsGarden();
		monetsGardenPage.changeLanguageToEnglish();

		Object selectedLanguageObject = page.evalOnSelector("#languagePicker", "el => el.value");

		String selectedLanguage = (String) selectedLanguageObject;

		assertEquals("en", selectedLanguage);
	}

	@Test
	public void testOpenTickets() {

		MonetsGardenNavPage monetsGardenPage = new MonetsGardenNavPage(page);
		monetsGardenPage.navToMonetsGarden();

		Page stockholmPopup = monetsGardenPage.openCityTickets("Stockholm");
		assertTrue(stockholmPopup.url().contains("https://www.eventim.se/eventseries/3289035/?affiliate=FKS"));
		monetsGardenPage.closePopup();

		Page malmoPopup = monetsGardenPage.openCityTickets("Malmö");
		assertTrue(malmoPopup.url().contains("https://www.eventim.se/eventseries/3264283/?affiliate=FKS"));
		monetsGardenPage.closePopup();
	}
}
