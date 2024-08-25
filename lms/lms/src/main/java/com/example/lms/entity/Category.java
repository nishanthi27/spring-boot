package com.example.lms.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column
	private String name;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<book> books;
	
//	constructor
	public Category()
	{
		
	}

	

}
