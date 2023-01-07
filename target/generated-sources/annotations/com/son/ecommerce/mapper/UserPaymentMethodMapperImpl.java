package com.son.ecommerce.mapper;

import com.son.ecommerce.dto.PaymentMethodDto;
import com.son.ecommerce.model.DefaultSettingEnum;
import com.son.ecommerce.model.UserPaymentMethod;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-06T19:17:56+0700",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 18.0.2.1 (Eclipse Adoptium)"
)
public class UserPaymentMethodMapperImpl implements UserPaymentMethodMapper {

    @Override
    public UserPaymentMethod dtoToModel(PaymentMethodDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserPaymentMethod userPaymentMethod = new UserPaymentMethod();

        userPaymentMethod.setAccountNumber( dto.getAccountNumber() );
        userPaymentMethod.setExpiryDate( dto.getExpiryDate() );
        userPaymentMethod.setId( dto.getId() );
        if ( dto.getIsDefault() != null ) {
            userPaymentMethod.setIsDefault( Enum.valueOf( DefaultSettingEnum.class, dto.getIsDefault() ) );
        }
        userPaymentMethod.setPaymentType( dto.getPaymentType() );
        userPaymentMethod.setProvider( dto.getProvider() );

        return userPaymentMethod;
    }

    @Override
    public PaymentMethodDto modelToDto(UserPaymentMethod model) {
        if ( model == null ) {
            return null;
        }

        PaymentMethodDto paymentMethodDto = new PaymentMethodDto();

        paymentMethodDto.setAccountNumber( model.getAccountNumber() );
        paymentMethodDto.setExpiryDate( model.getExpiryDate() );
        paymentMethodDto.setId( model.getId() );
        if ( model.getIsDefault() != null ) {
            paymentMethodDto.setIsDefault( model.getIsDefault().name() );
        }
        paymentMethodDto.setPaymentType( model.getPaymentType() );
        paymentMethodDto.setProvider( model.getProvider() );

        return paymentMethodDto;
    }
}
