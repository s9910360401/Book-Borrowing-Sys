package com.esunbankbookBorrowing.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.esunbankbookBorrowing.ultility.InventoryStatus;

@Entity
@Table(name = "Inventory")
public class InventoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Inventor_Id")
	private Integer inventoryId;
	
	@CreationTimestamp
	@Column(name="Store_Time", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = false, insertable = false)
	private Date storeTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Status")
	private InventoryStatus status;
	
    @ManyToOne
    @JoinColumn(name="isbn",insertable = false, updatable = false,nullable = false)
	private BookEntity bookEntity;
	
	public InventoryEntity() {
		super();
	}

	public InventoryEntity(Integer inventoryId, Date storeTime, InventoryStatus status, BookEntity bookEntity) {
		super();
		this.inventoryId = inventoryId;
		this.storeTime = storeTime;
		this.status = status;
		this.bookEntity = bookEntity;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Date getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(Date storeTime) {
		this.storeTime = storeTime;
	}
	public InventoryStatus getStatus() {
		return status;
	}
	public void setStatus(InventoryStatus status) {
		this.status = status;
	}
	public BookEntity getBookEntity() {
		return bookEntity;
	}
	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}
	
	

}
