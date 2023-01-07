package com.son.ecommerce.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "site_user")
public class SiteUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "email_address", unique = true)
	private String emailAddress;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private SiteUserRoleEnum role;

	@OneToMany(cascade = CascadeType.ALL, 
				fetch = FetchType.LAZY, 
				mappedBy = "siteUser")
	private Set<Address> addresses;
	
	@OneToMany(cascade = CascadeType.ALL,
			 	fetch = FetchType.LAZY, 
			 	mappedBy = "siteUser")
	private Set<UserPaymentMethod> paymentMethods;
}
