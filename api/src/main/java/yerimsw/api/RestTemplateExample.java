package yerimsw.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateExample {
    RestTemplate restTemplate = new RestTemplate();
    String apiUrl = "https://dummyjson.com/products/1";

    public void callApi() {
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        System.out.println(response);
    }
}
