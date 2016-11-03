package io.hackathon.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String product;
	
	@Column(nullable = false)
	private Date createdIn;
	
	@Column(nullable = false)
	private boolean goingWell;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="seller_id")
	private Profile seller;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="buyer_id")
	private Profile buyer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Date getCreatedIn() {
		return createdIn;
	}
	public void setCreatedIn(Date createdIn) {
		this.createdIn = createdIn;
	}
	public boolean isGoingWell() {
		return goingWell;
	}
	public void setGoingWell(boolean goingWell) {
		this.goingWell = goingWell;
	}
	public Profile getSeller() {
		return seller;
	}
	public void setSeller(Profile seller) {
		this.seller = seller;
	}
	public Profile getBuyer() {
		return buyer;
	}
	public void setBuyer(Profile buyer) {
		this.buyer = buyer;
	}
	
	

}
