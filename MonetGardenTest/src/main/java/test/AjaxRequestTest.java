package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import pages.AjaxRequestPage;
import testbase.TestBase;

public class AjaxRequestTest extends TestBase {

	@Test
	void TestandWait() {
		AjaxRequestPage action = new AjaxRequestPage(page);

		action.openPage();
		action.PressandWait();

		assertTrue(page.isVisible("p.bg-success:has-text(\"Data loaded with AJAX get request\")"));

	}
}
