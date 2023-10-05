package test;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import base.TestBase;

public class CarouselImageTest extends TestBase {
	
	@Test
	void CarouselButtonandImage () {
		
	    Locator carouselPrevButton;
	    Locator carouselNextButton;
	    Locator acceptCookies;
	    ElementHandle imageElement; 
	    
	    int numberOfClicks = 4;
	    
	    String selector = "img[srcset*='30fb7a8abd/mg27.jpg/m/384x0/filters:quality=(75)']";
	    String loginUrl = "https://monets-garden.se";
	    
	    
		// Navigation
		page.navigate(loginUrl);		
		
		// Accept Cookies
		acceptCookies = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Jag accepterar"));
        if (acceptCookies.isVisible()) {
            acceptCookies.click();
        }
        
        
        // carouselButtons
        carouselPrevButton = page.locator("button.Carousel_prevButton__OYQok");
        carouselNextButton = page.locator("button.Carousel_nextButton__GhXRI");
        
        //For-loop 
        for (int i = 0; i < numberOfClicks; i++) {
            carouselPrevButton.click();
        }
 
        for (int i = 0; i < numberOfClicks; i++) {
        	carouselNextButton.click();
        }
        
        // CHECK IMAGE
        
        imageElement = page.querySelector(selector);
        // Kontrollera om elementet hittades
        assert imageElement != null : "Bild med srcset hittades inte";
        // Hämta srcset-attributet
        String srcset = imageElement.getAttribute("srcset");
        assert srcset.contains("30fb7a8abd/mg27.jpg/m/384x0/filters:quality=(75)") : "Srcset är inte som förväntat";

        // Om assertionen misslyckas 
        if (!srcset.contains("30fb7a8abd/mg27.jpg/m/384x0/filters:quality=(75)")) {
            System.out.println("Felaktigt srcset. Förväntat srcset: '30fb7a8abd/mg27.jpg/m/384x0/filters:quality=(75)'");
            System.out.println("Aktuellt srcset: " + srcset);
        }

	}
}

