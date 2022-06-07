package com.redhat.sample.ecommerce.stock.service;

import com.redhat.sample.ecommerce.stock.domain.Stock;
import com.redhat.sample.ecommerce.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.stock.service.StockService
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Jun 2022 20:28
 */
@Transactional
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock getStock(Long id) {
        return stockRepository.findStockByProductIdEquals(id).orElse(new Stock());
    }
}
