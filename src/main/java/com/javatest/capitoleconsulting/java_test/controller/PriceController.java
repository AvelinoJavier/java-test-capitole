package com.javatest.capitoleconsulting.java_test.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatest.capitoleconsulting.java_test.domain.model.Price;
import com.javatest.capitoleconsulting.java_test.domain.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public Price getPrice(@RequestParam Long brandId, @RequestParam Long productId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime date) {
        return priceService.getPriceByBrandIdProductIdDate(brandId, productId, date);
    }

}
