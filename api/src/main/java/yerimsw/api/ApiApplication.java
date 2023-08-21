package yerimsw.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		RestTemplateExample restTemplateExample = new RestTemplateExample();
		restTemplateExample.callApi();

		WebClientExample webClientExample = new WebClientExample();
		webClientExample.callApi();
	}
}
