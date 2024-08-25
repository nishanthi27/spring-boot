package com.example.lms.service;

import java.util.List;

import com.example.lms.entity.book;
import com.example.lms.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.entity.Authors;
import com.example.lms.entity.Publisher;
import com.example.lms.repo.PublisherRepo;

@Service
public class PublisherService {
	@Autowired
	private PublisherRepo publisherRepo;

	@Autowired
	private BookRepo bookRepo;
	public List<Publisher> getAllPublisher()
	{
		return publisherRepo.findAll();
	}
	public Publisher getPublisherById(int id)
	{
		return publisherRepo.findById(id).orElse(null);
	}
	public Publisher savePublisher(String bookName, Publisher publisher)
	{
		book bookEntity = bookRepo.findByName(bookName);
		bookEntity.setPublisher(publisher);
		Publisher savedPublisher = publisherRepo.save(publisher);
		bookRepo.save(bookEntity);
		return savedPublisher;
	}
	public void deletepublisherbyid(int id)
	{
		publisherRepo.findById(id).orElse(null);
		publisherRepo.deleteById(id);
	}


	public Publisher updatePublisher(Publisher existingPublisher, Publisher publisher) {
		existingPublisher.setName(publisher.getName());
		return publisherRepo.save(existingPublisher);
	}
}
