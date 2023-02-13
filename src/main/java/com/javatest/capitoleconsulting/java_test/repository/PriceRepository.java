package com.javatest.capitoleconsulting.java_test.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javatest.capitoleconsulting.java_test.domain.model.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

    @Query("SELECT p FROM prices p WHERE p.brandId = :brandId AND p.productId = :productId AND :date BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC LIMIT 1")
    public Price getPriceByBrandIdProductIdDate(@Param("brandId") Long brandId, @Param("productId") Long productId,
            @Param("date") LocalDateTime date);

}
