package com.son.ecommerce.dto;

import com.son.ecommerce.model.DefaultSettingEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
	private long id;
	private String city;
	private String district;
	private String subDistrict;
	private String addressDetails;
	private DefaultSettingEnum isDefault;
}
