package com.son.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.son.ecommerce.model.Variation;

@Repository
public interface VariationRepository extends JpaRepository<Variation, Long> {

}
