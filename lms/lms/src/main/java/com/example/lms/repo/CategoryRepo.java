package com.example.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lms.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
