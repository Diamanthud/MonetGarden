package APIMethods;

import com.microsoft.playwright.Response;

import testbase.BaseAPI;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class ResponseDemo extends BaseAPI {

    @Test
    public void responseApiDemo() {

        Response r2 = page.navigate("https://playwright.dev");

        System.out.println(r2.url());
        System.out.println(r2.status());
        System.out.println(r2.ok()); // true if in the 200-299 range
        System.out.println(r2.headers());

        System.out.println(r2.body());
        System.out.println("Convert byte array to UTF.");
        System.out.println(new String(r2.body(), StandardCharsets.UTF_8));
        System.out.println("PW convenience method");
        System.out.println(r2.text());

    }

}