package com.redhat.sample.ecommerce.stock.domain;

import java.io.Serializable;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.stock.domain.Deduct
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 29 Jun 2022 14:23
 */
public class Deduct implements Serializable {
    private Long productId;
    private Long quantity;

    public Deduct() {
    }

    public Deduct(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
