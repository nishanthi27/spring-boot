package com.example.lms.service;

import java.util.List;

import com.example.lms.entity.book;
import com.example.lms.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.entity.Authors;
import com.example.lms.repo.AuthorRepo;

@Service

public class AuthorService {
	@Autowired
	private AuthorRepo authorRepo;

	@Autowired
	private BookRepo bookRepo;
	public List<Authors> getAllAuthors()
	{
		return authorRepo.findAll();
	}
	public Authors getAuthorById(int id)
	{
		return authorRepo.findById(id).orElseGet(null);
	}
	public Authors saveAuthors(String bookName, Authors author)
	{
		book bookEntity = bookRepo.findByName(bookName);
		System.out.println("bookname is:"+bookName);
		System.out.println("book entity is: "+bookEntity);
		bookEntity.setAuthors(author);
		authorRepo.save(author);
		bookRepo.save(bookEntity);
		return author;
	}

	public Authors updateAuthor(Authors existingValue, Authors authors){
		existingValue.setName(authors.getName());
		return authorRepo.save(existingValue);
	}
	public void deleteauthorbyid(int id)
	{
		authorRepo.findById(id).orElse(null);
		authorRepo.deleteById(id);
	}
	

}
