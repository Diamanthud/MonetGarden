package pages;

import com.microsoft.playwright.Page;

import com.microsoft.playwright.Locator;

import pagebase.PageBase;

public class TextandInputPage extends PageBase {
	Page page;
	String inputText;
	String inputTest;

	Locator updatingButton;
	Locator inputField;

	public TextandInputPage(Page page) {
		this.page = page;
		this.updatingButton = page.locator("#updatingButton").first();
		this.inputField = page.getByPlaceholder("MyButton");
	}

	public void openPage() {
		String homeUrl = "http://uitestingplayground.com/textinput/";
		page.navigate(homeUrl);
	}

	public void FillandClick(String inputText) {
		inputField.fill(inputText);
		updatingButton.click();
	}

	public String getInputText() {
		inputField = page.getByPlaceholder("MyButton");
		return inputField.inputValue();

	}
}