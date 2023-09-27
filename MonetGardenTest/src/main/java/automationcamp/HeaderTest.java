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
		
		// Hitta och klicka på knappen "Städer"
        page.click("button.Header_listButton__GUrK4");

        // Vänta på att listan med städer ska visas (du kan behöva ändra väntetiden beroende på webbplatsens respons)
        page.waitForSelector(".Header_innerList__wuB1y");

        // Hitta och klicka på länken "Stockholm"
        page.click("a[href='/stockholm']");
        
        // Lägg till dina egna assertions här om det behövs
        // Exempel: Kontrollera att du har nått den förväntade sidan efter klicket

        // Återgå till föregående sida (tillbaka till listan med städer)
        page.goBack();
        
        
    	// Hitta och klicka på knappen "Städer"
        page.click("button.Header_listButton__GUrK4");

        // Vänta på att listan med städer ska visas (du kan behöva ändra väntetiden beroende på webbplatsens respons)
        page.waitForSelector(".Header_innerList__wuB1y");
       
        // Hitta och klicka på länken "Malmö"
        page.click("a[href='/malmo']");

        // Lägg till dina egna assertions här om det behövs
        // Exempel: Kontrollera att du har nått den förväntade sidan efter klicket

        // Pausa i några sekunder för att observera effekten (kan användas för felsökning)
        page.waitForTimeout(5000); // 5 sekunder
		
		/*  
		//Locate elements
		Locator cityButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Städer"));
	        
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
