package spring.modelo.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import spring.modelo.model.LibroDTO;
import spring.modelo.services.LibroService;

@RestController
@RequestMapping("/books")
public class BookRestController {

	@Autowired
	LibroService libroService;
	
	
	@PostMapping()
	public ResponseEntity<?> createBook(@RequestBody @Validated LibroDTO book){
		
		libroService.createBook(book);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(book.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();		
		
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllBooks(){
		return ResponseEntity.ok(libroService.getAllbooks());
	}

}
