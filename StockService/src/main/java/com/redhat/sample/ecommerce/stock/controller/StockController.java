package com.redhat.sample.ecommerce.stock.controller;

import com.redhat.sample.ecommerce.stock.domain.Deduct;
import com.redhat.sample.ecommerce.stock.domain.Stock;
import com.redhat.sample.ecommerce.stock.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/v1/stock")
    public Stock getStock(@RequestParam Long productId) {
        return stockService.getStock(productId);
    }

    @PostMapping("/v1/stock/deduct")
    public ResponseEntity deduct(@RequestBody Deduct deduct) {
        try {
            stockService.deduct(deduct.getProductId(), deduct.getQuantity());
            return ResponseEntity.ok(new HashMap<>(){{
                put("status", "success");
                put("error", "");
            }});
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>(){{
                put("status", "failed");
                put("error", ex.getMessage());
            }});
        }
    }
}
