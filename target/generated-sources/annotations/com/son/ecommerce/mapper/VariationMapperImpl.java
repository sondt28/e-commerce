package com.son.ecommerce.mapper;

import com.son.ecommerce.dto.VariationDto;
import com.son.ecommerce.model.Variation;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-07T10:22:10+0700",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 18.0.2.1 (Eclipse Adoptium)"
)
public class VariationMapperImpl implements VariationMapper {

    @Override
    public VariationDto modelToDto(Variation model) {
        if ( model == null ) {
            return null;
        }

        VariationDto variationDto = new VariationDto();

        variationDto.setId( model.getId() );
        variationDto.setName( model.getName() );

        return variationDto;
    }

    @Override
    public Variation dtoToModel(VariationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Variation variation = new Variation();

        variation.setId( dto.getId() );
        variation.setName( dto.getName() );

        return variation;
    }
}
