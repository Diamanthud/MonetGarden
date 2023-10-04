package automationcamp;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByTextOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;

import base.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Kladd extends TestBase{

	@Test
	void NuTestarVi () {
		// Navigation
		String loginUrl = "https://monets-garden.se";
		page.navigate(loginUrl);		
		
		// Accept Cookies
		Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Jag accepterar"));
        if (acceptCookies.isVisible()) {
            acceptCookies.click();
        }
   
    	// ------BILJETTER------  
		page.click("button.Header_ctaButton__9S7Hn");
        page.waitForSelector(".Header_innerList__wuB1y");
        page.click("a[aria-label='Stockholm']");
      assertThat(page).hasURL("https://www.eventim.se/eventseries/3289035/?affiliate=FKS&_gl=1*bh7hfz*_gcl_au*MTU3NjEzNDc2NC4xNjk1OTY5MTk1");
        page.goBack();
        
        

	}
	}

