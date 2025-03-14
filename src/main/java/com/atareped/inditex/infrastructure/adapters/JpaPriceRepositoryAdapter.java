package com.atareped.inditex.infrastructure.adapters;

import com.atareped.inditex.domain.models.Price;
import com.atareped.inditex.domain.ports.out.PriceRepositoryPort;
import com.atareped.inditex.infrastructure.entities.PriceEntity;
import com.atareped.inditex.infrastructure.repositories.JpaPriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class JpaPriceRepositoryAdapter implements PriceRepositoryPort {
    private final JpaPriceRepository jpaPriceRepository;


    @Override
    public List<Price> findByDateAndProductIdAndBrandId(LocalDateTime date, Long productId, int brandId) {
        return jpaPriceRepository.findByDateAndByProductIdAndByBrandId(date, productId, brandId).stream()
                .map(PriceEntity::toDomainModel).collect(Collectors.toList());
    }
}
