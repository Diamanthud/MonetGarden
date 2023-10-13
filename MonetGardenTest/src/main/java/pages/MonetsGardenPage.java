package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import pagebase.PageBase;
import testbase.CookieHandler;

public class MonetsGardenPage extends PageBase {

	private Page page;
	private Page popupPage;

	public MonetsGardenPage(Page page) {
		this.page = page;
	}

	public void navToMonetsGarden() {
		String homeUrl = "https://monets-garden.se/";
		page.navigate(homeUrl);
		CookieHandler cookieHandler = new CookieHandler(page);
	    cookieHandler.acceptCookiesIfVisible();

	}

	public void navigateToStockholm() {
		clickOnCity("stockholm");
	}

	public void navigateToMalmo() {
		clickOnCity("malmo");
	}

	public void navigateToGallery() {
		page.click("text=Galleri");
	}

	public void navigateToFAQ() {
		page.click("text=Vanliga frågor");
	}

	public void navigateToContact() {
		page.click("text=kontakt");
	}

	public void changeLanguageToEnglish() {
		page.locator("#languagePicker").click();
		page.selectOption("#languagePicker", "en");
	}

	public Page openCityTickets(String city) {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Biljetter").setExact(true)).click();
		popupPage = page.waitForPopup(() -> {
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(city).setExact(true)).click();
		});
		return popupPage;
	}

	public void closePopup() {
		if (popupPage != null) {
			popupPage.close();
		}
	}

	private void clickOnCity(String cityName) {
		page.click("button.Header_listButton__GUrK4");
		page.waitForSelector(".Header_innerList__wuB1y");
		page.click("a[href='/" + cityName + "']");
	}
}
