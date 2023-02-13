package com.javatest.capitoleconsulting.java_test.domain.service;

import java.time.LocalDateTime;

import com.javatest.capitoleconsulting.java_test.domain.model.Price;

public interface PriceService {

    public Price getPriceByBrandIdProductIdDate(Long brandId, Long productId, LocalDateTime date);
    
}
