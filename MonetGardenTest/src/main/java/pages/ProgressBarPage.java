package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import testbase.TestBase;

public class ProgressBarPage extends TestBase {

	String ResultText;
	Page page;

	public ProgressBarPage(Page page) {
		this.page = page;
	}

	public void OpenProgressBarPage() {
		String homeUrl = "http://uitestingplayground.com/progressbar";
		page.navigate(homeUrl);
	}

	public void StartAndWaitForCompletion() {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
		page.waitForFunction("parseInt(document.querySelector('.progress-bar[aria-valuenow]').style.width) >= 75",
				null);
	}

	public void clickStop() {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Stop")).click();
	}

	public boolean progressBarIs75() {
		String progressBarWidthString = page
				.evaluate("document.querySelector('.progress-bar[aria-valuenow]').style.width").toString();
		int progressBarWidth = Integer.parseInt(progressBarWidthString.replace("%", ""));
		return progressBarWidth >= 75;

	}

	public boolean Result(String FinalResult) {
		page.waitForSelector("#result");
		ResultText = page.querySelector("#result").textContent();
		return ResultText.contains(FinalResult);

	}

}