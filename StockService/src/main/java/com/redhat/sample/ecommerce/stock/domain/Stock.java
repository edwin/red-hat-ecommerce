package com.redhat.sample.ecommerce.stock.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.stock.domain.Stock
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Jun 2022 20:26
 */
@Entity
@Table(name="T_STOCK")
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
