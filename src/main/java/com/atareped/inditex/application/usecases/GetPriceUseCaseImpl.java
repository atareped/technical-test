package com.atareped.inditex.application.usecases;

import com.atareped.inditex.commons.exceptions.PriceNotFoundException;
import com.atareped.inditex.commons.exceptions.UnexpectedDataBaseException;
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
        try {
            return priceRepositoryPort.findByDateAndProductIdAndBrandId(date, productId, brandId).stream()
                    .max(Comparator.comparing(Price::getPriority))
                    .orElseThrow(() -> new PriceNotFoundException("No price could be found"));
        } catch(Exception ex){
            if(ex instanceof PriceNotFoundException){
                throw ex;
            }
            throw new UnexpectedDataBaseException(ex.getMessage());
        }
    }
}
