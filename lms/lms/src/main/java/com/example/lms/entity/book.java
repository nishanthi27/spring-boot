package com.example.lms.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="books")

public class book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="author_id")
	private Authors authors;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
//	constructor - for getter setter
	public book()
	{
		
	}



	

}
