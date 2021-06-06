package org.example.book;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("book")
public class BookResource {

	
	@GetMapping("/teste/{cpf}")
	public ResponseEntity<Book> getScore(
			@RequestBody String data,
			@PathVariable(value = "cpf", required = false) String cpf,
			@RequestParam(value = "status", required = false) String status) {
		
		System.out.println("ID: " + cpf + " - Status: " + status + " data:" + data);
		
		return new ResponseEntity(new Book(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Book> getBook(
			@PathVariable(value = "id", required = false) String id,
			@RequestParam(value = "status", required = false) String status) {
		
		System.out.println("ID recebido: " + id + " - Status: " + status);
		
		return new ResponseEntity(new Book(), HttpStatus.OK);
	}

	@PostMapping(path = "{id}")
	public ResponseEntity<Book> createPost(
			@PathVariable(value = "id", required = false) String id,
			@RequestParam(value = "status", required = false) String status,
			HttpServletRequest request, 
			UriComponentsBuilder uriComponentsBuilder) {

		System.out.println("Status: " + status);
		
		var content = request.getParameter("content");

		var book = new Book();
		book.setId(1L);

		UriComponents uriComponents = uriComponentsBuilder.path("/book/{id}").buildAndExpand(book.getId());

		var location = uriComponents.toUri();

		return ResponseEntity.created(location).build();
	}

}
