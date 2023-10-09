package test;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;
import testbase.TestBase;

public class Example extends TestBase{


  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://monets-garden.se/");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jag accepterar")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Biljetter").setExact(true)).click();
      Page page1 = page.waitForPopup(() -> {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Stockholm").setExact(true)).click();
      });
      page1.navigate("https://www.eventim.se/eventseries/3289035/?affiliate=FKS&_gl=1*pi3lvt*_gcl_au*MTQxNDU2MjUwLjE2OTY0MTgyNDc.*_ga*NDE4Mzg2ODkyLjE2OTY0MTgyNDg.*_ga_6RNH50SJB8*MTY5NjQxODI0Ny4xLjAuMTY5NjQxODI0Ny42MC4wLjA.");
      page1.close();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Biljetter").setExact(true)).click();
      Page page2 = page.waitForPopup(() -> {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Malmö").setExact(true)).click();
      });
      page2.close();
      page.locator(".Carousel_dot__WUXF2").first().click();
      page.locator(".Carousel_dots__K6YZr > button:nth-child(2)").click();
      page.locator(".Carousel_dots__K6YZr > button:nth-child(3)").click();
      page.locator("button:nth-child(4)").first().click();
      page.locator("button:nth-child(5)").click();
    }
  }
}