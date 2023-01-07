package com.son.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_item")
public class ProductItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "SKU", length = 8)
	private String SKU;
	
	@Column(name = "qty_in_stock")
	private int quantityInStock;
	
	@Column(name = "product_image")
	private String productImage;
	
	@Column(name = "price")
	private float price;
}
