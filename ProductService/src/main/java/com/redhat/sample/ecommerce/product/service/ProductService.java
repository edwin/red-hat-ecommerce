package com.redhat.sample.ecommerce.product.service;

import com.redhat.sample.ecommerce.product.domain.Product;
import com.redhat.sample.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.product.service.ProductService
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Jun 2022 12:31
 */
@Transactional
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
