package com.son.ecommerce.mapper;

import com.son.ecommerce.dto.ProductCategoryDto;
import com.son.ecommerce.model.ProductCategory;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-07T09:47:16+0700",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 18.0.2.1 (Eclipse Adoptium)"
)
public class ProductCategoryMapperImpl implements ProductCategoryMapper {

    @Override
    public ProductCategory dtoToModel(ProductCategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductCategory productCategory = new ProductCategory();

        productCategory.setCategoryName( dto.getCategoryName() );
        Set<ProductCategory> set = dto.getChildrenCategory();
        if ( set != null ) {
            productCategory.setChildrenCategory( new HashSet<ProductCategory>( set ) );
        }
        productCategory.setId( dto.getId() );
        productCategory.setParentCategory( dto.getParentCategory() );

        return productCategory;
    }

    @Override
    public ProductCategoryDto modelToDto(ProductCategory model) {
        if ( model == null ) {
            return null;
        }

        ProductCategoryDto productCategoryDto = new ProductCategoryDto();

        productCategoryDto.setCategoryName( model.getCategoryName() );
        Set<ProductCategory> set = model.getChildrenCategory();
        if ( set != null ) {
            productCategoryDto.setChildrenCategory( new HashSet<ProductCategory>( set ) );
        }
        productCategoryDto.setId( model.getId() );
        productCategoryDto.setParentCategory( model.getParentCategory() );

        return productCategoryDto;
    }
}
