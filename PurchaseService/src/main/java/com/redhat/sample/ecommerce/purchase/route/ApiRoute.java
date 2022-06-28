package com.redhat.sample.ecommerce.purchase.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

import java.util.HashMap;

/**
 * <pre>
 *     com.redhat.sample.ecommerce.purchase.route.ApiRoute
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 28 Jun 2022 12:23
 */
public class ApiRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().bindingMode(RestBindingMode.json);

        rest("/")
                .get()
                .to("direct:index");

        from("direct:index")
                .setBody().constant(new HashMap<>(){{
            put("hello", "world");
        }});

        rest("/api/v1/purchase")
                .post()
                .to("direct:purchase-product");

        from("direct:purchase-product")
                .setBody().constant(new HashMap<>(){{
            put("hello", "world");
        }});
    }
}
