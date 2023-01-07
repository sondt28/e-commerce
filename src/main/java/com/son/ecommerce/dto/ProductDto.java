package com.son.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	private long id;
	private ProductCategoryDto productCategory;
	private String name;
	private String description;
	private String productImage;
}
