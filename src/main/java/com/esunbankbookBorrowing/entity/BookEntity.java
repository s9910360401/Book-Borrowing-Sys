package com.esunbankbookBorrowing.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="Book")
public class BookEntity {
	
	@Id
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="Book_Name")	
	private String name;
	
	@Column(name="Author")	
	private String author;
	
	@Column(name="Introduction")	
	private String introduction;
	
	@OneToMany(mappedBy="bookEntity")
	@JsonManagedReference
	private Set<InventoryEntity> inventoryEntity;
	
	public BookEntity() {
		super();
	}

	public BookEntity(String isbn, String name, String author, String introduction,
			Set<InventoryEntity> inventoryEntity) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.introduction = introduction;
		this.inventoryEntity = inventoryEntity;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Set<InventoryEntity> getInventoryEntity() {
		return inventoryEntity;
	}
	public void setInventoryEntity(Set<InventoryEntity> inventoryEntity) {
		this.inventoryEntity = inventoryEntity;
	}
	
}
