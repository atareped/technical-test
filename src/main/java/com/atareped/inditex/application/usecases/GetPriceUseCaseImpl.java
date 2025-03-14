package com.atareped.inditex.application.usecases;

import com.atareped.inditex.domain.models.Price;
import com.atareped.inditex.domain.ports.in.GetPriceUseCase;
import com.atareped.inditex.domain.ports.out.PriceRepositoryPort;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Comparator;

@AllArgsConstructor
public class GetPriceUseCaseImpl implements GetPriceUseCase {
    private PriceRepositoryPort priceRepositoryPort;

    @Override
    public Price getPriorityPrice(LocalDateTime date, Long productId, int brandId) {
        return priceRepositoryPort.findByDateAndProductIdAndBrandId(date, productId, brandId).stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElse(null);
    }
}
