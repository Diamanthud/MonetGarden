package pages;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import javax.lang.model.element.Element;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.options.AriaRole;

import pagebase.PageBase;

public class HomePage extends PageBase {

	Page page;
	Locator acceptCookies;
	boolean wasClicked;

	public HomePage(Page page) {
		this.page = page;
		this.acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar"));
		this.wasClicked = true;
	}

	public void MonetHomePage() {
		String homeUrl = "https://monets-garden.se";
		page.navigate(homeUrl);
		acceptCookiesIfVisible();
	}

	public boolean acceptCookiesIfVisible() {
		acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar"));
		wasClicked = false;

		if (acceptCookies.isVisible()) {
			acceptCookies.click();
			System.out.println("| Cookies Accepted |");
			wasClicked = true;
		} else {
			System.out.println("| Cookies Not Accepted |");
		}
		return wasClicked;
	}

	public void clickPreviousButton(int numberOfClicks) {
		for (int i = 0; i < numberOfClicks; i++) {
			page.locator("button.Carousel_prevButton__OYQok").click();
		}
	}

	public void clickNextButton(int numberOfClicks) {
		for (int i = 0; i < numberOfClicks; i++) {
			page.locator("button.Carousel_nextButton__GhXRI").click();
		}
	}

	public boolean isImagePresent(String imageUrl) {
		String imgSelector = "img[src*='" + imageUrl + "']";
		page.waitForSelector(imgSelector);
		return page.querySelector(imgSelector) != null;
	}

	public void waitForCarouselImage(String imageUrl) {
		String imgSelector = "img[src*='" + imageUrl + "']";
		page.waitForSelector(imgSelector);
	}

	public void clickCarouselDotButton() {
		String dotSelector = ".Carousel_dots__K6YZr > button";
		page.waitForSelector(dotSelector);
		List<Locator> dotElements = page.locator(dotSelector).all();

		for (Locator dotElement : dotElements) {
			dotElement.click();
		}

	}

}