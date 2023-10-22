package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.ProgressBarPage;
import testbase.TestBase;

public class ProgressBarTest extends TestBase {

	@Test
	void LoginTest() {
		ProgressBarPage test = new ProgressBarPage(page);

		test.OpenPage();

		test.StartAndWaitForCompletion();

		Assertions.assertTrue(test.progressBarIs75(), "Progress bar didn't reach 75% or more.");

		test.clickStop();

		String FinalResult = page.querySelector("#result").textContent();
		System.out.println(FinalResult);

		int resultElementCount = page.locator("#result").count();

		if (resultElementCount > 0) {
			String resultText = page.locator("#result").first().textContent();
			Assertions.assertTrue(resultText.contains("Result:"));
		} else {
			System.out.println("FEL");

		}
	}

}
