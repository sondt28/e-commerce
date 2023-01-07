package com.son.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.son.ecommerce.model.VariationOption;

@Repository
public interface VariationOptionRepository extends JpaRepository<VariationOption, Long> {

}
