package com.javatest.capitoleconsulting.java_test.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "prices")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double priceList;

    private Long productId;

    private Integer priority;

    private Double price;

    private String currency;

}
