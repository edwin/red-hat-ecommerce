package com.redhat.sample.ecommerce.product.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
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

    @Override
    public void configure() throws Exception {
        from("direct:getProducts")
            .routeId("getProducts")
            .tracing()
            .log("calling getProducts")
            .setBody(constant("{\"hello\":\"world\"}"))
            .end();
    }
}
