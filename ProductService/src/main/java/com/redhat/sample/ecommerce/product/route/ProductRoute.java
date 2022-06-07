package com.redhat.sample.ecommerce.product.route;

import com.redhat.sample.ecommerce.product.service.ProductService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * <pre>
 *     com.redhat.sample.ecommerce.product.route.ProductRoute
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 03 Jun 2022 10:50
 */
@Component
public class ProductRoute extends RouteBuilder {

    @Autowired
    private ProductService productService;

    @Override
    public void configure() throws Exception {
        from("direct:getProducts")
            .routeId("getProducts")
            .tracing()
            .log("calling getProducts")
            .process(exchange -> {
                exchange.getMessage().setBody(productService.getProducts());
            })
            .end();

        from("direct:getProduct")
                .routeId("getProduct")
                .tracing()
                .log("calling products ${body}")
                .process(exchange -> {
                    Long id = (Long) exchange.getIn().getBody();
                    exchange.getMessage().setBody(productService.getProduct(id));
                })
                .end();
    }
}
