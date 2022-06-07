package com.redhat.sample.ecommerce.stock.controller;

import com.redhat.sample.ecommerce.stock.domain.Stock;
import com.redhat.sample.ecommerce.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.stock.controller.StockController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Jun 2022 20:22
 */
@RestController
@RequestMapping("/api")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/v1/stock")
    public Stock getStock(@RequestParam Long productId) {
        return stockService.getStock(productId);
    }
}
