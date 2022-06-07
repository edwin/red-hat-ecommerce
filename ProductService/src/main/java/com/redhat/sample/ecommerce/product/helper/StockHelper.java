package com.redhat.sample.ecommerce.product.helper;

import com.redhat.sample.ecommerce.product.domain.Product;
import org.apache.camel.Body;
import org.apache.camel.Header;
import org.springframework.context.annotation.Bean;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.product.helper.StockHelper
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Jun 2022 15:35
 */
public class StockHelper {
    @Bean
    public Product addStockToProduct(@Body Product product, @Header("stock") String stock) {
        product.setStock(Long.parseLong(stock));
        return product;
    }
}
