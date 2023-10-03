package automationcamp;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByTextOptions;
import com.microsoft.playwright.options.AriaRole;

import base.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HeaderTest extends TestBase{

	@Test
	void NavListIsCorrect () {
		
		//NAVIGATION
		String loginUrl = "https://monets-garden.se";
		page.navigate(loginUrl);		
		
		// Accept Cookies
		Locator acceptCookies = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Jag accepterar"));
        if (acceptCookies.isVisible()) {
            acceptCookies.click();
        }
		
		//------STÄDER-----
		 //Hitta och klicka på knappen "Städer"
        page.click("button.Header_listButton__GUrK4");
        // Vänta på att listan med städer ska visas 
        page.waitForSelector(".Header_innerList__wuB1y");
        page.click("a[href='stockholm']");
           assertThat(page).hasURL("https://monets-garden.se/stockholm");
          page.goBack();
        
    	// Hitta och klicka på knappen "Städer" igen
        page.click("button.Header_listButton__GUrK4");
        // Vänta på att listan med städer ska visas
        page.waitForSelector(".Header_innerList__wuB1y");
        page.click("a[href='/malmo']");
           assertThat(page).hasURL("https://monets-garden.se/malmo");
          page.goBack();  
        
          
        // ------GALLERY------	
		page.click("text=Galleri");
	        assertThat(page).hasURL("https://monets-garden.se/gallery");
		  page.goBack();
		  
		  
        // ------VANLIGA FRÅGOR------ 
		page.click("text=Vanliga frågor");
	        assertThat(page).hasURL("https://monets-garden.se/#vanliga-fragor");
		  page.goBack();
  
		  
		// ------KONTAKT------
		page.click("text=kontakt");
	        assertThat(page).hasURL("https://monets-garden.se/#kontakt");
		  page.goBack();
		  
		// ------BILJETTER------  
		page.click("button.Header_ctaButton__9S7Hn");
        page.waitForSelector(".Header_innerList__wuB1y");
        page.click("a[aria-label='Stockholm']");
        assertThat(page).hasURL("https://www.eventim.se/eventseries/3289035/?affiliate=FKS&_gl=1*bh7hfz*_gcl_au*MTU3NjEzNDc2NC4xNjk1OTY5MTk1");
        page.goBack();
        
        /*
        page.click("a[href='/Stockholm']");
           assertThat(page).hasURL("https://www.eventim.se/eventseries/3289035/?affiliate=FKS&_gl=1*bh7hfz*_gcl_au*MTU3NjEzNDc2NC4xNjk1OTY5MTk1");
          page.goBack();*/
          
		  /*
          page.click("button.Header_ctaButton__9S7Hn");
          page.waitForSelector(".Header_innerList__wuB1y");
          await page.waitForSelector("a[href='/Stockholm']", { visible: true });
          page.click("a[href='/Stockholm']");
          assertThat(page).hasURL("https://www.eventim.se/eventseries/3289035/?affiliate=FKS&_gl=1*bh7hfz*_gcl_au*MTU3NjEzNDc2NC4xNjk1OTY5MTk1");
          page.goBack();*/
		  
		  
        /* Pausa i några sekunder för att observera effekten (kan användas för felsökning)
        page.waitForTimeout(5000); // 5 sekunder*/
		
		/*  
		//Locate elements
	        
		//Interact with elements
		cityButton.click();
	
		/*Navigation
		String loginUrl = "https://monets-garden.se";
		page.navigate(loginUrl);
		
		String title = page.title();
		System.out.println("Page Title is: " + title);
		*/
		
		//Locate elements
	
		/*
		//Assert result
		assertThat(header).isVisible();
		*/
		
	}

}
