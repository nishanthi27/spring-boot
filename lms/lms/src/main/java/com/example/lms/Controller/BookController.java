package com.example.lms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.entity.book;
import com.example.lms.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
@Autowired
private BookService bookService;

@GetMapping("/getAllBooks")
public ResponseEntity<List<book>> getAllBooks()
{
	List<book> books= bookService.getAllBooks();
	return ResponseEntity.ok(books);
}

@GetMapping("/getBookById/{id}")
public ResponseEntity<book> getBook(@PathVariable int id){
	book book= bookService.getBookById(id);
	if(book == null)
		return ResponseEntity.notFound().build();
	else
		return ResponseEntity.ok(book);
	
	
}

@PostMapping("/saveBook")
public ResponseEntity<book> saveBook(@RequestBody book book)
{
	 book createdbook= bookService.saveorupdateBooks(book);
	 return ResponseEntity.status(HttpStatus.CREATED).body(createdbook);
}

@PutMapping("/{id}")
public ResponseEntity<book> updateBook(@PathVariable int id , @RequestBody book book)
{
	book existingboBook= bookService.getBookById(id);
	if(existingboBook==null)
		return ResponseEntity.notFound().build();
	book.setId(id);
	bookService.saveorupdateBooks(book);
	return ResponseEntity.ok(book);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deletebook(@PathVariable int id)
{
	book book=bookService.getBookById(id);
	if(book == null)
		return ResponseEntity.notFound().build();
	bookService.deletebookbyid(id);
	return ResponseEntity.noContent().build();
}

}
