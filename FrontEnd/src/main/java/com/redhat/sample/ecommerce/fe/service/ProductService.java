package com.redhat.sample.ecommerce.fe.service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class ProductService {

    private List<Map> products = new ArrayList<>();
    private Map productNotFound = new HashMap();

    @PostConstruct
    public void populateData() throws Exception {
        products = Arrays.asList(new HashMap(){{
            put("productName", "Red Hat Hoodie");
            put("productDescription", "District Re-Fleece breathes new life into reclaimed materials with its 100% recycled fabric. Comfortable and never re-dyed, it’s a fleece that just feels good.");
            put("productImage", "static/1629331866_large.jpg");
            put("productStock", 1);
            put("productPrice", "$24.99");
            put("productId", 1);
        }}, new HashMap(){{
            put("productName", "Ansible Cap");
            put("productDescription", "An authentic silhouette with the comfort of an unstructured, adjustable fit.");
            put("productImage", "static/1632867337_large.jpg");
            put("productId", 2);
            put("productStock", 5);
            put("productPrice", "$10.99");
        }}, new HashMap(){{
            put("productName", "Red Hat Pen");
            put("productDescription", "This gel pen is one of the new eco-friendly items in the Eco-Minded product line. The barrel and cap of this translucent pen are made with 100% post-consumer recycled P.E.T. plastic.");
            put("productImage", "static/1633984381_large.jpg");
            put("productId", 3);
            put("productStock", 11);
            put("productPrice", "$3.99");
        }});

        productNotFound = new HashMap(){{
            put("productName", "Not Found");
            put("productDescription", "N/A .");
            put("productImage", "static/404.jpg");
            put("productId", 0);
            put("productStock", 0);
            put("productPrice", "$0.00");
        }};
    }

    public Map getProduct(Integer productId) {
        if(productId <= products.size())
            return products.get(productId-1);
        return productNotFound;
    }

    public List<Map> getProducts( ) {
        return products;
    }

}
