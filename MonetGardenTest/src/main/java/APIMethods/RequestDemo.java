package APIMethods;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Request;
import com.microsoft.playwright.Response;

import testbase.BaseAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestDemo extends BaseAPI {

    @Test
    public void requestDemo() {

        Response response = page.navigate("https://playwright.dev/");
        Request request = response.request();
        
        System.out.println(request.headers());
        System.out.println(request.postData());
        System.out.println(request.method());
        
        APIResponse apiResponse = context.request().get("https://playwright.dev/");
        Assertions.assertEquals(apiResponse.status(), 200);
    }

}