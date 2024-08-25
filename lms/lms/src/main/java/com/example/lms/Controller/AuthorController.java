package com.example.lms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.lms.entity.Authors;
import com.example.lms.entity.book;
import com.example.lms.service.AuthorService;
import com.example.lms.service.BookService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	@GetMapping
	public ResponseEntity<List<Authors>> getAllAuthors()
	{
		List<Authors> authors= authorService.getAllAuthors();
		return ResponseEntity.ok(authors);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Authors> getAuthor(@PathVariable int id){
		Authors authors= authorService.getAuthorById(id);
		if(authors == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(authors);
		
		
	}
	
	@PostMapping("/addAuthor")
	public ResponseEntity<Authors> saveAuthor(@RequestParam(value = "bookName") String bookName, @RequestBody Authors authors)
	{
		 Authors createdauthor= authorService.saveAuthors(bookName, authors);
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdauthor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Authors> updateAuthor(@PathVariable int id , @RequestBody Authors authors)
	{
		Authors existingauthor= authorService.getAuthorById(id);
		if(existingauthor==null)
			return ResponseEntity.notFound().build();
		authorService.updateAuthor(existingauthor, authors);
		return ResponseEntity.ok(authors);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteauthor(@PathVariable int id)
	{
		Authors authors=authorService.getAuthorById(id);
		if(authors == null)
			return ResponseEntity.notFound().build();
		authorService.deleteauthorbyid(id);
		return ResponseEntity.noContent().build();
	}
	

}
