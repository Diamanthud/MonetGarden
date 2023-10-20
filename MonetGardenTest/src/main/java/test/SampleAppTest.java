package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.*;
import testbase.TestBase;

public class SampleAppTest extends TestBase {

	@Test
	void LoginTest() {

		SampleAppPage sampleAppPage = new SampleAppPage(page);

		sampleAppPage.openPage();
		sampleAppPage.login("Testaren", "pwd");

		String username = sampleAppPage.getUsernameInputValue();
		String expectedWelcomeText = "Welcome, " + username;

		boolean isLoginStatusCorrect = sampleAppPage.isLoginStatusContains(expectedWelcomeText);

		Assertions.assertTrue(isLoginStatusCorrect);
		System.out.println(expectedWelcomeText);
	}

	@Test
	void LoginFailure() {
		SampleAppPage sampleAppPage = new SampleAppPage(page);

		sampleAppPage.openPage();
		sampleAppPage.login("Testaren", "PASSWORD");

		String username = sampleAppPage.getUsernameInputValue();
		String expectedWelcomeText = "Welcome, " + username;

		boolean isLoginStatusCorrect = sampleAppPage.isLoginStatusContains(expectedWelcomeText);

		Assertions.assertTrue(isLoginStatusCorrect);
		System.out.println(expectedWelcomeText);
	}

}
