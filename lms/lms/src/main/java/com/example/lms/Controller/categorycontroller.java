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

import com.example.lms.entity.Category;
import com.example.lms.entity.book;
import com.example.lms.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class categorycontroller {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories()
	{
		List<Category> categories= categoryService.getAllCategory();
		return ResponseEntity.ok(categories);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable int id){
		Category category= categoryService.getCategoryById(id);
		if(category == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(category);
		
		
	}

	@PostMapping
	public ResponseEntity<Category> saveCategory(@RequestBody Category category)
	{
		 Category createdcategory= categoryService.saveorupdateCategory(category);
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdcategory);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id , @RequestBody Category category)
	{
		Category existingCatgory= categoryService.getCategoryById(id);
		if(existingCatgory==null)
			return ResponseEntity.notFound().build();
		category.setId(id);
		categoryService.saveorupdateCategory(category);
		return ResponseEntity.ok(category);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable int id)
	{
		Category category=categoryService.getCategoryById(id);
		if(category == null)
			return ResponseEntity.notFound().build();
		categoryService.deletecategorybyid(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
