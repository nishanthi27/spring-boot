package com.example.lms.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name="authors")
public class Authors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column
	private String name;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "authors", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<book> books;
	
	public Authors()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<book> getBooks() {
		return books;
	}

	public void setBooks(List<book> books) {
		this.books = books;
	}

}
