package com.son.ecommerce.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_payment_method")
public class UserPaymentMethod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	private SiteUser siteUser;
	
	@Enumerated(EnumType.STRING)
	private PaymentTypeEnum paymentType;
	
	@Column(name = "provider")
	private String provider;
	
	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "expriry_date")
	private LocalDate expiryDate;
	
	@Enumerated(EnumType.STRING)
	private DefaultSettingEnum isDefault;
}
