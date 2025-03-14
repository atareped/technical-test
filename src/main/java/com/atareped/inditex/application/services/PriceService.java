package com.atareped.inditex.application.services;

import com.atareped.inditex.domain.models.Price;
import com.atareped.inditex.domain.ports.in.GetPriceUseCase;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PriceService implements GetPriceUseCase {
    private GetPriceUseCase getPriceUseCase;

    @Override
    public Price getPriorityPrice(LocalDateTime date, Long productId, int brandId) {
        return getPriceUseCase.getPriorityPrice(date, productId, brandId);
    }
}
