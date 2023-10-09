package codeGenGenerator;

import org.junit.jupiter.api.Test;


import com.microsoft.playwright.*;
import com.microsoft.playwright.Page.GetByTextOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;

import testbase.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Generator extends TestBase{
	
		@Test
		void FixTrix() {
			
		String loginUrl = "https://monets-garden.se";
	page.navigate(loginUrl);	

	
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar")).click();
    
     
     
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Biljetter").setExact(true)).click();
     Page page1 = page.waitForPopup(() -> {
       page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Stockholm").setExact(true)).click();
     });
     page1.close();
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Biljetter").setExact(true)).click();
     Page page2 = page.waitForPopup(() -> {
       page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Malmö").setExact(true)).click();
     });
     page2.close();
     
     page.locator(".Carousel_dots__K6YZr").click();
     page.locator(".Carousel_dots__K6YZr > button:nth-child(2)").click();
     page.locator(".Carousel_dots__K6YZr > button:nth-child(3)").click();
     page.locator("button:nth-child(4)").first().click();
     page.locator("button:nth-child(5)").click();
     page.locator(".Carousel_dot__WUXF2").first().click();
     
     Page page3 = page.waitForPopup(() -> {
       page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Frågor").setExact(true)).click();
     });
     page3.close();
     
     
     Page page4 = page.waitForPopup(() -> {
       page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Press").setExact(true)).click();
     });
     page4.close();
    
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Scroll to top")).click();
     page.getByRole(AriaRole.BANNER).getByRole(AriaRole.LINK).first().click();
     page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Stockholm Stockholm Sjöhistoriska 2023-10-06 – 2024-01-21 Info och biljetter")).click();
     page.locator(".container > .Carousel_wrapper__T46_C > .keen-slider > div:nth-child(2) > .StoryblokImage_wrapper__1I4DO").click();
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Om biljetter")).click();
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kommer Monets tavlor att visas upp?")).click();


		}
		
}



	
	
	
	
	
