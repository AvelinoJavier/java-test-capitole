package com.javatest.capitoleconsulting.java_test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import com.javatest.capitoleconsulting.java_test.JavaTestApplication;
import com.javatest.capitoleconsulting.java_test.domain.model.Price;

@SpringBootTest(classes = JavaTestApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "classpath:data.sql" })
    @Test
    public void getPrice() throws Exception {

        String case1 = "brandId=1&productId=35455&date=2020-06-14-10.00.00";
        Double expectedPrice1 = 35.50;

        String case2 = "brandId=1&productId=35455&date=2020-06-14-16.00.00";
        Double expectedPrice2 = 25.45;

        String case3 = "brandId=1&productId=35455&date=2020-06-14-21.00.00";
        Double expectedPrice3 = 35.50;

        String case4 = "brandId=1&productId=35455&date=2020-06-15-10.00.00";
        Double expectedPrice4 = 30.50;

        String case5 = "brandId=1&productId=35455&date=2020-06-16-21.00.00";
        Double expectedPrice5 = 38.95;

        Price obteinedPrice1 = this.restTemplate
                .getForObject("http://localhost:" + port + "/price?" + case1, Price.class);

        assertThat(obteinedPrice1).extracting(Price::getPrice).isEqualTo(expectedPrice1);

        Price obteinedPrice2 = this.restTemplate
                .getForObject("http://localhost:" + port + "/price?" + case2, Price.class);

        assertThat(obteinedPrice2).extracting(Price::getPrice).isEqualTo(expectedPrice2);

        Price obteinedPrice3 = this.restTemplate
                .getForObject("http://localhost:" + port + "/price?" + case3, Price.class);

        assertThat(obteinedPrice3).extracting(Price::getPrice).isEqualTo(expectedPrice3);

        Price obteinedPrice4 = this.restTemplate
                .getForObject("http://localhost:" + port + "/price?" + case4, Price.class);

        assertThat(obteinedPrice4).extracting(Price::getPrice).isEqualTo(expectedPrice4);

        Price obteinedPrice5 = this.restTemplate
                .getForObject("http://localhost:" + port + "/price?" + case5, Price.class);

        assertThat(obteinedPrice5).extracting(Price::getPrice).isEqualTo(expectedPrice5);
    }
}
