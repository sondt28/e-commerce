package com.son.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.son.ecommerce.common.exception.VariationOptionException;
import com.son.ecommerce.dto.VariationOptionDto;
import com.son.ecommerce.mapper.VariationOptionMapper;
import com.son.ecommerce.model.VariationOption;
import com.son.ecommerce.repository.VariationOptionRepository;

@Service
public class VariationOptionServiceImpl implements VariationOptionService {

	@Autowired
	private VariationOptionRepository repository;
	
	@Override
	public List<VariationOptionDto> findAll() {
		
		List<VariationOption> variations = repository.findAll();
		List<VariationOptionDto> dtos = variations.stream()
								.map(t -> VariationOptionMapper.INSTANCE.modelToDto(t))
								.collect(Collectors.toList());
		return dtos;
	}

	@Override
	public VariationOptionDto save(VariationOptionDto dto) {
		VariationOption variationOption = VariationOptionMapper.INSTANCE.dtoToModel(dto);
		
		VariationOptionDto newDto = VariationOptionMapper.INSTANCE
					.modelToDto(repository.save(variationOption));
		
		return newDto;
	}

	@Override
	public VariationOptionDto update(long id, VariationOptionDto dto) {
		VariationOption variationOption = repository.findById(id)
				.orElseThrow(() -> new VariationOptionException("Variation option not found."));
		
		variationOption.setValue(dto.getValue());
		
		VariationOptionDto updateDto = VariationOptionMapper.INSTANCE
				.modelToDto(repository.save(variationOption));
		
		return updateDto;
	}

	@Override
	public VariationOptionDto findById(long id) {
		VariationOption variationOption = repository.findById(id)
				.orElseThrow(() -> new VariationOptionException("Variation option not found."));
		
		VariationOptionDto updateDto = VariationOptionMapper.INSTANCE
				.modelToDto(repository.save(variationOption));
		
		return updateDto;
	}

	@Override
	public void delete(long id) {
		VariationOption variationOption = repository.findById(id)
				.orElseThrow(() -> new VariationOptionException("Variation option not found."));
		
		repository.delete(variationOption);
	}

}
