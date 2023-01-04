package com.son.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.son.ecommerce.dto.RegisterDto;
import com.son.ecommerce.model.SiteUser;

@Mapper
public interface SiteUserMapper {

	SiteUserMapper INSTANCE = Mappers.getMapper(SiteUserMapper.class);
	
	SiteUser registerToUser(RegisterDto dto);
}
