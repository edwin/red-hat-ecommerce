package com.redhat.sample.ecommerce.product.route;

import com.redhat.sample.ecommerce.product.domain.Stock;
import com.redhat.sample.ecommerce.product.helper.StockHelper;
import com.redhat.sample.ecommerce.product.service.ProductService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${stock-service.get-stock.endpoint}")
    private String stockServiceURL;

    @Override
    public void configure() throws Exception {

        // get all products
        from("direct:getProducts")
            .routeId("getProducts")
            .tracing()
            .log("calling getProducts")
            .process(exchange -> {
                exchange.getMessage().setBody(productService.getProducts());
            })
            .end();

        // get one product
        from("direct:getProduct")
                .routeId("getProduct")
                .tracing()
                .setHeader("productId",  simple("${body}"))
                .to("direct:getStock")
                .log("calling products with productId ${header.productId}")
                .process(exchange -> {
                    Long id = (Long) exchange.getIn().getHeader("productId");
                    exchange.getMessage().setBody(productService.getProduct(id));
                })
                .bean(StockHelper.class, "addStockToProduct")
                .end();

        // get stock from one product
        from("direct:getStock")
                .log("calling stock with productId ${header.productId}")
                .toD(stockServiceURL+"?productId=${header.productId}")
                .log("Response body from stockServiceURL is ${body}")
                .unmarshal().json(JsonLibrary.Jackson, Stock.class)
                .process(exchange -> {
                    exchange.getIn().setHeader("stockNumber",
                            exchange.getMessage().getBody(Stock.class).getStockNumber());
                });
    }
}
