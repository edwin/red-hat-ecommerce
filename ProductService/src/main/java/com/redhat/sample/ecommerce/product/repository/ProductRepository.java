package com.redhat.sample.ecommerce.product.repository;

import com.redhat.sample.ecommerce.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.product.repository.ProductRepository
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Jun 2022 12:30
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
