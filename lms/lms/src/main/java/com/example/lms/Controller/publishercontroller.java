package com.example.lms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.lms.entity.Category;
import com.example.lms.entity.Publisher;
import com.example.lms.repo.PublisherRepo;
import com.example.lms.service.PublisherService;

@RestController
@RequestMapping("/api/publisher")
public class publishercontroller {
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping
	public ResponseEntity<List<Publisher>> getAllPublisher()
	{
		List<Publisher> publishers= publisherService.getAllPublisher();
		return ResponseEntity.ok(publishers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Publisher> getPublisher(@PathVariable int id){
		Publisher publisher= publisherService.getPublisherById(id);
		if(publisher == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(publisher);
		
		
	}

	@PostMapping("/addPublisher")
	public ResponseEntity<Publisher> savepublisher(@RequestParam(value = "bookName") String bookName, @RequestBody Publisher publisher)
	{
		 Publisher createdPublisher= publisherService.savePublisher(bookName, publisher);
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdPublisher);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Publisher> updatepublisher(@PathVariable int id , @RequestBody Publisher publisher)
	{
		Publisher existingPublisher= publisherService.getPublisherById(id);
		if(existingPublisher==null)
			return ResponseEntity.notFound().build();
		Publisher savedPublisher = publisherService.updatePublisher(existingPublisher, publisher);
		return ResponseEntity.ok(savedPublisher);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePublisher(@PathVariable int id)
	{
		Publisher publisher=publisherService.getPublisherById(id);
		if(publisher == null)
			return ResponseEntity.notFound().build();
		publisherService.deletepublisherbyid(id);
		return ResponseEntity.noContent().build();
	}
	
	

	

}
