package com.example.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lms.entity.book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepo extends JpaRepository<book,Integer>{

    @Query(value = "SELECT * FROM books WHERE books.name =:bookName", nativeQuery = true)
    book findByName(@Param("bookName") String bookName);
}
