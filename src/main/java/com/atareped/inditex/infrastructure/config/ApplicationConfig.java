package com.atareped.inditex.infrastructure.config;

import com.atareped.inditex.application.services.PriceService;
import com.atareped.inditex.application.usecases.GetPriceUseCaseImpl;
import com.atareped.inditex.domain.ports.out.PriceRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public PriceService priceService(PriceRepositoryPort priceRepositoryPort){
            return new PriceService(new GetPriceUseCaseImpl(priceRepositoryPort));
    }
}
