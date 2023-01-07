package com.son.ecommerce.mapper;

import com.son.ecommerce.dto.RegisterDto;
import com.son.ecommerce.model.SiteUser;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-06T19:17:56+0700",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 18.0.2.1 (Eclipse Adoptium)"
)
public class SiteUserMapperImpl implements SiteUserMapper {

    @Override
    public SiteUser registerToUser(RegisterDto dto) {
        if ( dto == null ) {
            return null;
        }

        SiteUser siteUser = new SiteUser();

        siteUser.setEmailAddress( dto.getEmailAddress() );
        siteUser.setPassword( dto.getPassword() );
        siteUser.setPhoneNumber( dto.getPhoneNumber() );

        return siteUser;
    }
}
