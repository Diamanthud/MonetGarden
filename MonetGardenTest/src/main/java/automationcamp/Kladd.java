package automationcamp;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByTextOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;

import base.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.regex.Pattern;

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
   
        
       Locator biljetterBtnLocator = page.locator("button.Header_ctaButton__9S7Hn:has-text('Biljetter')");
       biljetterBtnLocator.click();
       
       
      /* 
       page.waitForSelector(".Header_innerList__wuB1y");
       page.click("a[href='https://www.eventim.se/eventseries/3289035/?affiliate=FKS&_gl=1*1iqqpwf*_gcl_au*Mjc5NTk1MTIyLjE2OTYyMzA4NTg.']");
      //    assertThat(page).hasURL("https://monets-garden.se/stockholm");
         page.goBack();
      */
       
       /* Hitta och klicka på länken "Stockholm"
       Locator stockholmLinkLocator = page.getByRole(AriaRole.BUTTON,
    		   new Page.GetByRoleOptions().setName("a.Header_link__trIMx[href*='Stockholm']"));
       stockholmLinkLocator.click();*/
       
      /* Locator sthlmLink = page.locator("a.Header_link__trIMx[href*='Stockholm']");
       sthlmLink.waitForElementState(ElementState.VISIBLE).click();*
               
      /*
        page.click("button.Header_ctaButton__9S7Hn");
        page.waitForSelector(".Header_innerList__wuB1y");

        page.locator("'Header_innerList__wuB1y')a[contains(text(), 'Stockholm')]").click();
      
        page.goBack();*/
        
        // page.click(".Header_innerList__wuB1y .Header_linkItem__ADvmc:has-text('Stockholm')");
        
        // assertThat(page).hasURL("https://www.eventim.se/eventseries/3289035/?affiliate=FKS&_gl=1*bh7hfz*_gcl_au*MTU3NjEzNDc2NC4xNjk1OTY5MTk1");
		
		
	}
	}

