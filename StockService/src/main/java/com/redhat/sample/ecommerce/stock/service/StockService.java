package com.redhat.sample.ecommerce.stock.service;

import com.redhat.sample.ecommerce.stock.domain.Stock;
import com.redhat.sample.ecommerce.stock.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StockRepository stockRepository;

    public Stock getStock(Long id) {
        return stockRepository.findStockByProductIdEquals(id).orElse(new Stock());
    }

    public void deduct(Long productId, Long quantity) throws Exception {
        Stock stock = stockRepository.findStockByProductIdEquals(productId).orElseThrow(() -> new Exception(String.format("ProductId %s is not found", productId)));

        // get stock on hand
        Long stockAmount = stock.getStockNumber();

        // validate stock is available
        if(stockAmount < quantity) {
            logger.error("Stock on hand for {} is not enough", stock.getProductId());
            throw new Exception(String.format("Stock on hand for %s is not enough", productId));
        }

        // deduct
        stock.setStockNumber(stockAmount - quantity);

        // save to db
        stockRepository.save(stock);
    }
}
