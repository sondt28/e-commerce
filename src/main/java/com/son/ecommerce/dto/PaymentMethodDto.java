package com.son.ecommerce.dto;

import java.time.LocalDate;

import com.son.ecommerce.model.PaymentTypeEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentMethodDto {
	private long id;
	private PaymentTypeEnum paymentType;
	private String provider;
	private String accountNumber;
	private LocalDate expiryDate;
	private String isDefault;
}
