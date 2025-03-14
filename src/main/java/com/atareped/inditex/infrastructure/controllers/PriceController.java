package com.atareped.inditex.infrastructure.controllers;

import com.atareped.inditex.application.services.PriceService;
import com.atareped.inditex.domain.models.Price;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/price")
@AllArgsConstructor
public class PriceController {
    private final PriceService priceService;

    @GetMapping("/{productId}/{brandId}/{date}")
    public ResponseEntity<Price> getPrice(@PathVariable LocalDateTime date,
                                          @PathVariable Long productId, @PathVariable int brandId){
        return new ResponseEntity<>(priceService.getPriorityPrice(date, productId, brandId), HttpStatus.OK);
    }
}
