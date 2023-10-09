package APIMethods;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetAPIEndpoints {
    public static void main(String[] args) {
        try {
            String serverIP = "75.2.60.5:"; // Replace with the actual IP address
            String url = "https://monets-garden.se/"; // Replace with the complete URL

            // Make an HTTP GET request
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();

            if (statusCode == HttpURLConnection.HTTP_OK) {
                // Successfully fetched the page
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse the HTML content with JSoup
                Document doc = Jsoup.parse(response.toString());

                // Now you can work with the JSoup Document
                // For example, you can extract and print text from <p> elements
                System.out.println(doc.select("p").text());
            } else {
                // Handle different HTTP response status codes
                System.out.println("HTTP request failed with status code: " + statusCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}