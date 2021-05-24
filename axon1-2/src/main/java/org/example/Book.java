package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String author;
}
