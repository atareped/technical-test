package com.atareped.inditex.domain.ports.out;

import com.atareped.inditex.domain.models.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {
    List<Price> findByDateAndProductIdAndBrandId(LocalDateTime date, Long productId, int brandId);
}