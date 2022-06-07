package com.redhat.sample.ecommerce.product.controller;

import com.redhat.sample.ecommerce.product.domain.Product;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.product.controller.ProductController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 03 Jun 2022 10:53
 */
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProducerTemplate template;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return (List<Product>) template.requestBody("direct:getProducts", "");
    }

    @GetMapping("/product")
    public Product getProduct(@RequestParam("id") Long id) {
        return (Product) template.requestBody("direct:getProduct", id);
    }
}
