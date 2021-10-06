package com.microservice.paymentService.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class CartRestConsumer {

    @Autowired
    private DiscoveryClient client;

    public String getCartInfo() {
        List<ServiceInstance> serviceInstanceList = client.getInstances("cartService"); // service Id push
        ServiceInstance serviceInstance = serviceInstanceList.get(0);
        String url = serviceInstance.getUri() + "/cart/getData";

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);

        return response;
    }


}
