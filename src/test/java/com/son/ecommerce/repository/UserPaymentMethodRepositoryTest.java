package com.son.ecommerce.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.son.ecommerce.model.UserPaymentMethod;

@DataJpaTest
public class UserPaymentMethodRepositoryTest {

	@Autowired
	private UserPaymentMethodRepository repository;
	
	private UserPaymentMethod paymentMethod;
	
	@BeforeEach
	void beforeEach() {
		paymentMethod = new UserPaymentMethod();
		paymentMethod.setExpiryDate(LocalDate.of(2002, 12, 1));
	}
	
	@Test
	void savePaymentMethod() {
		UserPaymentMethod actual = repository.save(paymentMethod);
		assertEquals(LocalDate.of(2002, 12, 1), actual.getExpiryDate());
	}
}
