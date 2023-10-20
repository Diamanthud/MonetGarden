package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.MonetGardenImgPage;
import testbase.TestBase;

public class CarouselImageTest extends TestBase {

	@Test
	void CarouselButtonandImage() {
		MonetGardenImgPage homePage = new MonetGardenImgPage(page);
		homePage.MonetHomePage();

		page.waitForSelector(".keen-slider");
		page.waitForSelector("img[src*='mg20.jpg']");

		String[] imageUrls = { "mg20.jpg", "mg9.jpg", "monets-garten-wien-c-philipplipiarski_03.jpg", "mg27.jpg",
				"mg25.jpg" };

		homePage.clickPreviousButton(5);
		for (String imageUrl : imageUrls) {
			boolean isImagePresent = homePage.isImagePresent(imageUrl);
			Assertions.assertTrue(isImagePresent, "Image " + imageUrl + " is not present in the carousel");
		}

		homePage.clickNextButton(5);
	}

	@Test
	public void testCarouselImages() {

		MonetGardenImgPage homePage = new MonetGardenImgPage(page);
		homePage.MonetHomePage();

		String[] imageUrls = { "mg20.jpg", "mg9.jpg", "monets-garten-wien-c-philipplipiarski_03.jpg", "mg27.jpg",
				"mg25.jpg" };

		for (String imageUrl : imageUrls) {
			homePage.waitForCarouselImage(imageUrl);
			homePage.clickCarouselDotButton();

			boolean isImagePresent = page.querySelector("img[src*='" + imageUrl + "']") != null;
			boolean isDotButtonPresent = page.querySelector(".Carousel_dots__K6YZr > button") != null;

			Assertions.assertTrue(isImagePresent, "Image " + imageUrl + " is not present in the carousel");
			Assertions.assertTrue(isDotButtonPresent, "Dot button for Image " + imageUrl + " is not present");
		}
	}

}