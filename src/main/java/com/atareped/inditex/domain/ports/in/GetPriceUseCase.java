package com.atareped.inditex.domain.ports.in;

import com.atareped.inditex.domain.models.Price;

import java.time.LocalDateTime;

public interface GetPriceUseCase {
    Price getPriorityPrice(LocalDateTime date, Long productId, int brandId);
}
