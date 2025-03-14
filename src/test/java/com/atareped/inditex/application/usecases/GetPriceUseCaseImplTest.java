package com.atareped.inditex.application.usecases;

import com.atareped.inditex.domain.models.Price;
import com.atareped.inditex.domain.ports.out.PriceRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetPriceUseCaseImplTest {
    private PriceRepositoryPort priceRepositoryPort;
    private GetPriceUseCaseImpl getPriceUseCaseimpl;

    @BeforeEach
    void setUp() {
        priceRepositoryPort = mock(PriceRepositoryPort.class);
        getPriceUseCaseimpl = new GetPriceUseCaseImpl(priceRepositoryPort);
    }

    @Test
    void shouldGetPriorityPrice(){
        //do
        LocalDateTime date = LocalDateTime.now();
        Long productId = 2L;
        int brandId = 1;

        Price expectedPrice = getPrice(1, 33);

        List<Price> priceList = new ArrayList<>();
        priceList.add(getPrice(0, 55));
        priceList.add(expectedPrice);

        when(priceRepositoryPort.findByDateAndProductIdAndBrandId(date, productId, brandId))
                .thenReturn(priceList);

        //when
        var result = getPriceUseCaseimpl.getPriorityPrice(date, productId, brandId);

        //then
        assertEquals(expectedPrice, result);
    }

    private Price getPrice(int priority, int price){
        return Price.builder()
                .id(1L)
                .brandId(1)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(5))
                .priceList(2)
                .productId(2L)
                .priority(priority)
                .price(price)
                .currency("EUR")
                .build();
    }
}
