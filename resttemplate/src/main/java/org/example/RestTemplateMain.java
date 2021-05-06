package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateMain {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		/*
		String fooResourceUrl = "https://pokeapi.co/api/v2/item/";
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
		System.out.println(response);
		*/
		
		String fooResourceUrl = "https://pokeapi.co/api/v2/item/";
		ResponseEntity<Item> item = restTemplate.getForEntity(fooResourceUrl + "/1", Item.class);
		System.out.println(item.getBody().getId());
		
	}

	static class Item {
		private Integer id;
		
		public Integer getId() {
			return id;
		}
		
		@Override
		public String toString() {
			return "Item[id=" + id + "]";
		}
	}
}
