package com.javatest.capitoleconsulting.java_test.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatest.capitoleconsulting.java_test.domain.model.Price;
import com.javatest.capitoleconsulting.java_test.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Price getPriceByBrandIdProductIdDate(Long brandId, Long productId, LocalDateTime date) {
        return priceRepository.getPriceByBrandIdProductIdDate(brandId, productId, date);
    }

}
