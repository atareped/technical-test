package com.atareped.inditex.application.services;

import com.atareped.inditex.domain.models.Price;
import com.atareped.inditex.domain.ports.in.GetPriceUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceServiceTest {

    private GetPriceUseCase getPriceUseCase;

    private PriceService priceService;



    @BeforeEach
    void setUp() {
        getPriceUseCase = mock(GetPriceUseCase.class);
        priceService = new PriceService(getPriceUseCase);
    }

    @Test
    void shouldGetPriorityPrice(){
        //do
        LocalDateTime date = LocalDateTime.now();
        Long productId = 2L;
        int brandId = 1;

        Price expectedPrice = Price.builder()
                .id(1L)
                .brandId(1)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(5))
                .priceList(2)
                .productId(2L)
                .priority(1)
                .price(33)
                .currency("EUR")
                .build();

        when(getPriceUseCase.getPriorityPrice(date, productId, brandId)).thenReturn(expectedPrice);

        //when
        var result = priceService.getPriorityPrice(date, productId, brandId);
        //then
        assertEquals(expectedPrice, result);
    }
}
