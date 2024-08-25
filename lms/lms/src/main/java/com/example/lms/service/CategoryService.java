package com.example.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.entity.Authors;
import com.example.lms.entity.Category;
import com.example.lms.repo.CategoryRepo;

@Service

public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	public List<Category> getAllCategory()
	{
		return categoryRepo.findAll();
	}
	public Category getCategoryById(int id)
	{
		return categoryRepo.findById(id).orElse(null);
	}
	public Category saveorupdateCategory(Category category)
	{
		return categoryRepo.save(category);
	}
	public void deletecategorybyid(int id)
	{
		categoryRepo.findById(id).orElse(null);
		categoryRepo.deleteById(id);
	}

	

}
