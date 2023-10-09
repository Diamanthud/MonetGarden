package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;

import pages.HomePage;
import testbase.CookieHandler;
import testbase.TestBase;

public class CarouselImageTest extends TestBase {

	@Test
	void CarouselButtonandImage() {

		Locator carouselPrevButton;
		Locator carouselNextButton;
		ElementHandle imageElement;

		int numberOfClicks = 4;
		String selector = "img[srcset*='30fb7a8abd/mg27.jpg/m/384x0/filters:quality=(75)']";

		HomePage homePage = new HomePage(page);
		CookieHandler cookieHandler = new CookieHandler(page);

		homePage.OpenHomePage();
		cookieHandler.acceptCookiesIfVisible();

		// carouselButtons
		carouselPrevButton = page.locator("button.Carousel_prevButton__OYQok");
		carouselNextButton = page.locator("button.Carousel_nextButton__GhXRI");

		// For-loop
		for (int i = 0; i < numberOfClicks; i++) {
			carouselPrevButton.click();
		}
		for (int i = 0; i < numberOfClicks; i++) {
			carouselNextButton.click();
		}
		// carouselDots
		page.locator(".Carousel_dots__K6YZr").click();
		page.locator(".Carousel_dots__K6YZr > button:nth-child(2)").click();
		page.locator(".Carousel_dots__K6YZr > button:nth-child(3)").click();
		page.locator("button:nth-child(4)").first().click();
		page.locator("button:nth-child(5)").click();
		page.locator(".Carousel_dot__WUXF2").first().click();

		// Assertion
		Assertions.assertTrue(page.locator(".Carousel_dots__K6YZr").count() > 0); // Check the first element was clicked
		Assertions.assertTrue(page.locator(".Carousel_dots__K6YZr > button:nth-child(2)").count() > 0);
		Assertions.assertTrue(page.locator(".Carousel_dots__K6YZr > button:nth-child(3)").count() > 0);
		Assertions.assertTrue(page.locator("button:nth-child(4)").count() > 0);
		Assertions.assertTrue(page.locator("button:nth-child(5)").count() > 0);
		Assertions.assertTrue(page.locator(".Carousel_dot__WUXF2").count() > 0);

		// CHECK IMAGE
		imageElement = page.querySelector(selector);
		assert imageElement != null : "Bild med srcset hittades inte";
		String srcset = imageElement.getAttribute("srcset");
		assert srcset.contains("30fb7a8abd/mg27.jpg/m/384x0/filters:quality=(75)") : "Srcset är inte som förväntat";
		if (!srcset.contains("30fb7a8abd/mg27.jpg/m/384x0/filters:quality=(75)")) {
			System.out
					.println("Felaktigt srcset. Förväntat srcset: '30fb7a8abd/mg27.jpg/m/384x0/filters:quality=(75)'");
			System.out.println("Aktuellt srcset: " + srcset);
		}

	}
}