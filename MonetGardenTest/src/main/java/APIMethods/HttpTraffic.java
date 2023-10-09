package APIMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import testbase.BaseAPI;

import java.util.ArrayList;
import java.util.List;

public class HttpTraffic extends BaseAPI {


    @Test
    public void HttpTrafficDemo() {

        List<Integer> responses = new ArrayList<>();
        page.onResponse(response -> responses.add(response.status()));

        page.navigate("https://playwright.dev/");

        // Print each response status code on a separate line
        for (Integer response : responses) {
            System.out.println(response);
        }

        boolean foundMatch = responses.stream()
                .anyMatch(i -> i < 200 || i >= 300);

        Assertions.assertFalse(foundMatch);
    }
}