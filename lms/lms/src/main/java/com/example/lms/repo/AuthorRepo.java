package com.example.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lms.entity.Authors;

import jakarta.persistence.criteria.CriteriaBuilder.In;
@Repository

public interface AuthorRepo extends JpaRepository<Authors,Integer>{

}
