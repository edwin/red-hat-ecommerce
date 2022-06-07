package com.redhat.sample.ecommerce.stock.repository;

import com.redhat.sample.ecommerce.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.stock.repository.StockRepository
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Jun 2022 20:28
 */
public interface StockRepository extends JpaRepository<Stock, Long> {
    public Optional<Stock> findStockByProductIdEquals(Long productId);
}
