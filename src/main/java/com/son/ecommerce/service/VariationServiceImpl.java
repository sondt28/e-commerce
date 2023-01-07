package com.son.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.son.ecommerce.common.exception.VariationException;
import com.son.ecommerce.dto.VariationDto;
import com.son.ecommerce.mapper.VariationMapper;
import com.son.ecommerce.model.Variation;
import com.son.ecommerce.repository.VariationRepository;

@Service
public class VariationServiceImpl implements VariationService {

	@Autowired
	private VariationRepository repository;
	
	@Override
	public List<VariationDto> findAll() {
		List<Variation> variations = repository.findAll();
		
		List<VariationDto> dtos = variations.stream()
						.map(t -> VariationMapper.INSTANCE.modelToDto(t))
						.collect(Collectors.toList());	
		return dtos;
	}

	@Override
	public VariationDto save(VariationDto dto) {
		Variation variation = VariationMapper.INSTANCE.dtoToModel(dto);
		
		repository.save(variation);
		
		VariationDto newDto = VariationMapper.INSTANCE.modelToDto(variation);
	
		return newDto;
	}

	@Override
	public VariationDto update(long id, VariationDto dto) {
		Variation variation = repository.findById(id)
				.orElseThrow(() -> new VariationException("Variation not found."));
		
		variation.setName(dto.getName());
		repository.save(variation);
		
		VariationDto updateDto = VariationMapper.INSTANCE.modelToDto(variation);
		return updateDto;
	}

	@Override
	public VariationDto findById(long id) {
		Variation variation = repository.findById(id)
				.orElseThrow(() -> new VariationException("Variation not found."));
	
		VariationDto dto = VariationMapper.INSTANCE.modelToDto(variation);
		
		return dto;
	}

	@Override
	public void delete(long id) {
		Variation variation = repository.findById(id)
				.orElseThrow(() -> new VariationException("Variation not found."));
		
		repository.delete(variation);
	}
}
