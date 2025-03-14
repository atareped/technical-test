package com.atareped.inditex.infrastructure.repositories;

import com.atareped.inditex.infrastructure.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query(value = "select * from Prices p " +
            "where ?1 between p.start_date and p.end_date " +
            "and p.product_id = ?2 " +
            "and p.brand_id = ?3",
            nativeQuery = true)
    List<PriceEntity> findByDateAndByProductIdAndByBrandId(LocalDateTime date, Long productId, int brandId);
}
