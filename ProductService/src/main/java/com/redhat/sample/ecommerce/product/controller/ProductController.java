package com.redhat.sample.ecommerce.product.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.product.controller.ProductController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 03 Jun 2022 10:53
 */
@RestController
public class ProductController {

    @Autowired
    private ProducerTemplate template;

    @GetMapping(value = "/api/v1/products",
            produces="application/json")
    public String getProducts() {
        return template.requestBody("direct:getProducts", "").toString();
    }
}
