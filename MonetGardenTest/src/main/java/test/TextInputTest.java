package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.TextandInputPage;
import testbase.TestBase;

public class TextInputTest extends TestBase {

	@Test
	void InputButtonTest() {
		TextandInputPage textInputPage = new TextandInputPage(page);

		textInputPage.openPage();
		String oldButtonName = page.querySelector("#updatingButton").textContent();
		System.out.println("Old button name = " + oldButtonName);

		textInputPage.FillandClick("Tryck på mig");

		String newButtonName = page.querySelector("#updatingButton").textContent();
		String inputText = textInputPage.getInputText();
		System.out.println("New button name = " + newButtonName);

		boolean evaluate = newButtonName.equals(inputText);

		if (evaluate) {
			Assertions.assertTrue(evaluate);
		} else {
			Assertions.assertFalse(evaluate);
		}

	}
}