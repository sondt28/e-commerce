package com.son.ecommerce.service;

import java.util.List;

import com.son.ecommerce.dto.VariationDto;

public interface VariationService {
	List<VariationDto> findAll();
	VariationDto save(VariationDto dto);
	VariationDto update(long id, VariationDto dto);
	VariationDto findById(long id);
	void delete(long id);
}
