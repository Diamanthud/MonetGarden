package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import pagebase.PageBase;

import pages.HomePage;
import test.AcceptCookies;
import testbase.TestBase;

public class MonetsGardenPage extends PageBase{
    private final Page page;


    public MonetsGardenPage(Page page, BrowserContext context) {
        this.page = page;
    }

    public void navigateToMonetsGarden() {
    	String homeUrl = "https://monets-garden.se/";
		page.navigate(homeUrl);		
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

    public void openStockholmTickets() {
        openCityTickets("Stockholm");
    }

    public void openMalmoTickets() {
        openCityTickets("Malmö");
    }

    public void changeLanguageToEnglish() {
        page.locator("#languagePicker").click();
        page.selectOption("#languagePicker", "en");
    }

    private void clickOnCity(String cityName) {
        page.click("button.Header_listButton__GUrK4");
        page.waitForSelector(".Header_innerList__wuB1y");
        page.click("a[href='/" + cityName + "']");
    }

    private void openCityTickets(String cityName) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Biljetter").setExact(true)).click();
        Page popup = page.waitForPopup(() -> {
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(cityName).setExact(true)).click();
        });
        popup.close();
    }
}