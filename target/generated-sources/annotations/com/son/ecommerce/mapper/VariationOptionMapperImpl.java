package com.son.ecommerce.mapper;

import com.son.ecommerce.dto.VariationOptionDto;
import com.son.ecommerce.model.VariationOption;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-07T10:30:02+0700",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 18.0.2.1 (Eclipse Adoptium)"
)
public class VariationOptionMapperImpl implements VariationOptionMapper {

    @Override
    public VariationOptionDto modelToDto(VariationOption model) {
        if ( model == null ) {
            return null;
        }

        VariationOptionDto variationOptionDto = new VariationOptionDto();

        variationOptionDto.setId( model.getId() );
        variationOptionDto.setValue( model.getValue() );

        return variationOptionDto;
    }

    @Override
    public VariationOption dtoToModel(VariationOptionDto dto) {
        if ( dto == null ) {
            return null;
        }

        VariationOption variationOption = new VariationOption();

        variationOption.setId( dto.getId() );
        variationOption.setValue( dto.getValue() );

        return variationOption;
    }
}
