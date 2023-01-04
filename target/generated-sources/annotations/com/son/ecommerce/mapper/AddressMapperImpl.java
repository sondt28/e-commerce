package com.son.ecommerce.mapper;

import com.son.ecommerce.dto.AddressDto;
import com.son.ecommerce.model.Address;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-04T17:54:38+0700",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 18.0.2.1 (Eclipse Adoptium)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDto addressToAddressDto(Address model) {
        if ( model == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setAddressDetails( model.getAddressDetails() );
        addressDto.setCity( model.getCity() );
        addressDto.setDistrict( model.getDistrict() );
        addressDto.setId( model.getId() );
        addressDto.setIsDefault( model.getIsDefault() );
        addressDto.setSubDistrict( model.getSubDistrict() );

        return addressDto;
    }

    @Override
    public Address dtoToModel(AddressDto dto) {
        if ( dto == null ) {
            return null;
        }

        Address address = new Address();

        address.setAddressDetails( dto.getAddressDetails() );
        address.setCity( dto.getCity() );
        address.setDistrict( dto.getDistrict() );
        address.setId( dto.getId() );
        address.setIsDefault( dto.getIsDefault() );
        address.setSubDistrict( dto.getSubDistrict() );

        return address;
    }
}
