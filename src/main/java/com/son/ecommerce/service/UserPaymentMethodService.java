package com.son.ecommerce.service;

import java.util.List;

import com.son.ecommerce.dto.PaymentMethodDto;

public interface UserPaymentMethodService {

	List<PaymentMethodDto> findAllBySiteUser();
	PaymentMethodDto save(PaymentMethodDto dto);
	PaymentMethodDto findById(long id);
	void delete(long id);
}
