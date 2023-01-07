package com.son.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.son.ecommerce.common.exception.UserPaymentMethodException;
import com.son.ecommerce.dto.PaymentMethodDto;
import com.son.ecommerce.mapper.UserPaymentMethodMapper;
import com.son.ecommerce.model.DefaultSettingEnum;
import com.son.ecommerce.model.SiteUser;
import com.son.ecommerce.model.UserPaymentMethod;
import com.son.ecommerce.repository.UserPaymentMethodRepository;

@Service
public class UserPaymentMethodServiceImpl implements UserPaymentMethodService {

	@Autowired
	private UserPaymentMethodRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Override
	public List<PaymentMethodDto> findAllBySiteUser() {
		SiteUser siteUser = authService.findCurrentUser();
		
		List<UserPaymentMethod> paymentMethods = repository.findBySiteUser(siteUser);
		List<PaymentMethodDto> dtos = paymentMethods.stream()
										.map(t -> UserPaymentMethodMapper.INSTANCE.modelToDto(t))
										.collect(Collectors.toList());
		
		return dtos;
	}

	@Override
	public PaymentMethodDto save(PaymentMethodDto dto) {
		SiteUser siteUser = authService.findCurrentUser();
		List<UserPaymentMethod> paymentMethod = repository.findBySiteUser(siteUser);
		
		paymentMethod.forEach(t -> t.setIsDefault(DefaultSettingEnum.N));
		repository.saveAll(paymentMethod);
		
		UserPaymentMethod paymentMethodCurrent = UserPaymentMethodMapper.INSTANCE.dtoToModel(dto);
		paymentMethodCurrent.setSiteUser(siteUser);
		paymentMethodCurrent.setIsDefault(DefaultSettingEnum.Y);
		paymentMethodCurrent.getExpiryDate().withDayOfMonth(01);
		
		PaymentMethodDto newDto = UserPaymentMethodMapper
								.INSTANCE.modelToDto(repository.save(paymentMethodCurrent));
		
		return newDto;
	}

	@Override
	public PaymentMethodDto findById(long id) {
		
		UserPaymentMethod paymentMethod = repository.findById(id)
				.orElseThrow(() -> new UserPaymentMethodException("Payment method not found."));
		
		return UserPaymentMethodMapper.INSTANCE.modelToDto(paymentMethod);
	}

	@Override
	public void delete(long id) {
		UserPaymentMethod paymentMethod = repository.findById(id)
				.orElseThrow(() -> new UserPaymentMethodException("Payment method not found."));
		
		repository.delete(paymentMethod);
	}
}
