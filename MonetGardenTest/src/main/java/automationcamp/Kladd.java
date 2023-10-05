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

import java.util.List;


public class Kladd extends TestBase{

	@Test
	void NuTestarVi () {

	    Locator acceptCookies;
	    Locator PremiärBokaBiljett;
	    String loginUrl = "https://monets-garden.se";
	    
	    
		// Navigation
		page.navigate(loginUrl);		
		
		// Accept Cookies
		acceptCookies = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Jag accepterar"));
        if (acceptCookies.isVisible()) {
            acceptCookies.click();
        }
        
       
        
        /*
        PremiärBokaBiljett = page.locator("div.Hero_sticker___a60T a.Sticker_link__T4_Rz");
        PremiärBokaBiljett.click();*/
        
	}
}
