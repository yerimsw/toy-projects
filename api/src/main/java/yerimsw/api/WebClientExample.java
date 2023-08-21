package yerimsw.api;

import org.springframework.web.reactive.function.client.WebClient;

public class WebClientExample {
    WebClient client = WebClient.builder()
            .baseUrl("https://dummyjson.com/products")
            .build();

    public void callApi() {
        client.get()
                .uri("/2")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(
                        response -> System.out.println(response)
                );
    }
}
