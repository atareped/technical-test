package com.atareped.inditex.infrastructure.repositories;

import com.atareped.inditex.infrastructure.entities.PriceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class JpaPriceRepositoryTest {

    @Autowired
    JpaPriceRepository jpaPriceRepository;

    @Test
    void shouldGetPricesByDateAndProductIdAndGroupId(){
        //do
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 15, 30, 0);
        Long productId = 35455L;
        int brandId = 1;

        PriceEntity price1 = PriceEntity.builder()
                .id(1L)
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .priceList(1)
                .productId(35455L)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build();

        PriceEntity price2 = PriceEntity.builder()
                .id(2L)
                .brandId(1)
                .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
                .priceList(2)
                .productId(35455L)
                .priority(1)
                .price(25.45)
                .curr("EUR")
                .build();

        List<PriceEntity> expectedResult = new ArrayList<>();
        expectedResult.add(price1);
        expectedResult.add(price2);

        //when
        var result = jpaPriceRepository.findByDateAndByProductIdAndByBrandId(date, productId, brandId);

        //then
        assertEquals(expectedResult, result);
    }
}
