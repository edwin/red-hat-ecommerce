package com.redhat.sample.ecommerce.product.domain;

import java.io.Serializable;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.product.domain.Stock
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Jun 2022 21:55
 */
public class Stock implements Serializable {
    private Long id;

    private Long productId;
    private Long stockNumber;

    public Stock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Long stockNumber) {
        this.stockNumber = stockNumber;
    }
}
