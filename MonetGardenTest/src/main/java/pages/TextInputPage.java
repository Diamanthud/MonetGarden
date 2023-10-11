package pages;

import com.microsoft.playwright.Page;

import org.junit.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import pagebase.PageBase;

public class TextInputPage extends PageBase {
	Page page;

	public TextInputPage(Page page) {
		this.page = page;

	}

	public void performButtonClickSequenceWithInput(String inputText) {
		String homeUrl = "http://uitestingplayground.com/textinput/";
		page.navigate(homeUrl);

		String placeholder = "MyButton";
			
			// Click on the button
		    page.getByPlaceholder(placeholder).click();

		    // Fill in the input text
		    page.getByPlaceholder(placeholder).fill(inputText);

		    // If the inputText is "NyKnappMedEnter," press Enter
		    if (inputText.equals("NyKnappMedEnter")) {
		        page.getByPlaceholder(placeholder).press("Enter");
		    }

		    // Click the button again if needed
		    if (inputText.equals("NyKnappMedClick") || inputText.equals("NyKnappMedClick2")) {
		        page.getByPlaceholder(placeholder).click();
		        System.out.println("test1");
		    }

		    // Handle specific case for changing button name
		    if (inputText.equals("NyKnappMedClick")) {
		        Page.GetByRoleOptions options = new Page.GetByRoleOptions()
		                .setName("Button That Should Change it's Name Based on Input Value");
		        page.getByRole(AriaRole.BUTTON, options).click();
		        System.out.println("Test2");
		    }
		    
		 
	}}


