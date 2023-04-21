package com.esunbankbookBorrowing.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "Borrowing_Record")
public class RecordEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Record_Id")
	private Integer recordId;
	
	@Column(name="User_Id")
	private Integer userId;
	
	@Column(name="Inventor_Id")
	private Integer inventoryId;
	
	@CreationTimestamp
	@Column(name="Borrowing_Time ", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = false, insertable = false)
	private Timestamp borrowingTime;
	
	@Column(name="Return_Time", columnDefinition = "TIMESTAMP")
	private Timestamp returnTime;	

	public RecordEntity() {
		super();
	}

	public RecordEntity(Integer recordId, Integer userId, Integer inventoryId, Timestamp borrowingTime,
			Timestamp returnTime) {
		super();
		this.recordId = recordId;
		this.userId = userId;
		this.inventoryId = inventoryId;
		this.borrowingTime = borrowingTime;
		this.returnTime = returnTime;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Timestamp getBorrowingTime() {
		return borrowingTime;
	}

	public void setBorrowingTime(Timestamp borrowingTime) {
		this.borrowingTime = borrowingTime;
	}

	public Timestamp getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Timestamp returnTime) {
		this.returnTime = returnTime;
	}

	
	
	
}
