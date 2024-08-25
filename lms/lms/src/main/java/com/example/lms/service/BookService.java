package com.example.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.entity.Authors;
import com.example.lms.entity.book;
import com.example.lms.repo.BookRepo;

@Service

public class BookService {
	@Autowired
	private BookRepo bookRepo;
	public List<book> getAllBooks()
	{
		return bookRepo.findAll();
	}
	public book getBookById(int id)
	{
		return bookRepo.findById(id).orElse(null);
	}
	public book saveorupdateBooks(book book)
	{
		return bookRepo.save(book);
	}
	public void deletebookbyid(int id)
	{
		bookRepo.findById(id).orElse(null);
		bookRepo.deleteById(id);
	}

	
	

}
