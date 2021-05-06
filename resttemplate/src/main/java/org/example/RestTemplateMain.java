package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateMain {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrl = "https://pokeapi.co/api/v2/item/";

		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);

		System.out.println(response.getStatusCode());
	}

}
