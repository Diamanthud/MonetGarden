package test;

import static org.junit.Assert.assertTrue;

import javax.lang.model.element.Element;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.ElementHandle.WaitForSelectorOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions.IsVisibleOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.Media;

import pages.AjaxRequestPage;
import pages.MonetGardenImgPage;
import pages.VisibilityPage;
import testbase.TestBase;

public class VisibilityTest extends TestBase {

	@Test
	public void testAcceptCookies() {

		VisibilityPage visibilityPage = new VisibilityPage(page);

		visibilityPage.OpenPage();

		visibilityPage.ClickonHideButton();

		Locator isZeroWidthButtonVisible = page.locator("#zeroWidthButton");

		Object width = isZeroWidthButtonVisible
				.evaluate("element => window.getComputedStyle(element).getPropertyValue('width')");

		boolean hasZeroWidth = "0px".equals(width);

		if (hasZeroWidth) {
			System.out.println("Zero Width Button is Hidden: true");
		} else {
			System.out.println("The button does not have zero width and i visible");
		}

		Locator zeroOpacityButton = page.locator("#transparentButton");

		Object opacity = zeroOpacityButton
				.evaluate("element => window.getComputedStyle(element).getPropertyValue('opacity')");

		boolean hasZeroOpacity = "0".equals(opacity);

		if (hasZeroOpacity) {
			System.out.println("The button has zero opacity and is not visible.");
		} else {
			System.out.println("The button does not have zero opacity and is visible.");
		}

		Locator overlappedElement = page.locator("#overlappedButton");

		Object width1 = overlappedElement
				.evaluate("element => window.getComputedStyle(element).getPropertyValue('width')");
		Object height = overlappedElement
				.evaluate("element => window.getComputedStyle(element).getPropertyValue('height')");

		boolean isNotPracticallyVisible = "0px".equals(width1) && "0px".equals(height);

		if (isNotPracticallyVisible) {
			System.out.println("The element is not practically visible due to overlap.");
		} else {
			System.out.println("The element is practically visible.");
		}

		boolean isZeroWidthButtonVisible1 = page.isHidden("#zeroWidthButton");
		boolean isOpacity0ButtonVisible = page.isHidden("#transparentButton");
		boolean isVisibilityHiddenButtonVisible = page.isHidden("#invisibleButton");
		boolean isDisplayNoneButtonVisible = page.isVisible("#notdisplayedButton");
		boolean isOffscreenButtonNotVisible = !page.isVisible(".offscreen");

		System.out.println("Zero Width Button is Hidden: " + isZeroWidthButtonVisible1);
		System.out.println("Opacity 0 Button is visible: " + isOpacity0ButtonVisible);
		System.out.println("Visibility Hidden Button is Hidden: " + isVisibilityHiddenButtonVisible);
		System.out.println("Display None Button is visible: " + isDisplayNoneButtonVisible);
		System.out.println("Offscreen Button is visible: " + isOffscreenButtonNotVisible);

	}

}
