package com.atareped.inditex.infrastructure.controllers;

import com.atareped.inditex.domain.models.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static java.lang.Double.parseDouble;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerIntegrationTest {

    @Autowired
    private TestRestTemplate client;

    @Test
    void shouldGetTheProperPrice(){
        //do
        String date = "2020-06-14T15:30:00";
        long productId = 35455L;
        int brandId = 1;

        Price expectedPrice = Price.builder()
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
                .priceList(2)
                .productId(35455L)
                .price(25.45)
                .currency("EUR")
                .build();

        String url = "/price/" + productId + "/" + brandId + "/" + date;

        //when
        ResponseEntity<Price> response = client.getForEntity(url, Price.class);

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        assertNotNull(response.getBody());
        assertEquals(expectedPrice, response.getBody());
    }

    @ParameterizedTest
    @CsvSource({"35455, 1, 2020-06-14T10:00:00, 35.50", "35455, 1, 2020-06-14T16:00:00, 25.45",
            "35455, 1, 2020-06-14T21:00:00, 35.50", "35455, 1, 2020-06-15T10:00:00, 30.50",
            "35455, 1, 2020-06-16T21:00:00, 38.95"})
    void shouldGetTheProperPriceGivenThisParameters(ArgumentsAccessor argumentsAccessor){
        //do
        String url = "/price/" +
                argumentsAccessor.getString(0) + "/" +
                argumentsAccessor.getString(1) + "/" +
                argumentsAccessor.getString(2);

        double expectedPrice = parseDouble(argumentsAccessor.getString(3));
        //when
        ResponseEntity<Price> response = client.getForEntity(url, Price.class);

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        assertNotNull(response.getBody());
        assertEquals(expectedPrice, response.getBody().getPrice());
    }
}
