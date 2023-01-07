package com.son.ecommerce.dto;

import java.util.Set;

import com.son.ecommerce.model.ProductCategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductCategoryDto {
	private long id;
	private String categoryName;
	private ProductCategory parentCategory;
	private Set<ProductCategory> childrenCategory;
}
