package com.example.faultToleranceresilience4J.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class CircuitBreakerController {

    Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/getInvoice")
    /**
     * This is where circuit breaker comes into play
     */
    @CircuitBreaker(name = "getInvoiceCB", fallbackMethod = "getInvoiceFallback")
    public String getInvoice() {
        logger.info("getInvoice() call starts here");
        ResponseEntity<String> entity= restTemplate.getForEntity("http://localhost:8080/invoice/rest/find/2", String.class);
        logger.info("Response :" + entity.getStatusCode());
        return entity.getBody();
    }

    public String getInvoiceFallback(Exception e) {
        logger.info("---RESPONSE FROM FALLBACK METHOD---");
        return "SERVICE IS DOWN, PLEASE TRY AFTER SOMETIME !!!";
    }

    /**
     * 1) ‘failure-rate-threshold=80‘ indicates that if 80% of requests are getting failed,
     *      open the circuit ie. Make the Circuit Breaker state as Open.
     * 2) ‘sliding-window-size=10‘ indicates that if 80% of requests out of 10 (it means 8) are failing,
     *      open the circuit.
     * 3) ‘sliding-window-type=COUNT_BASED‘ indicates that we are using COUNT_BASED sliding window.
     *      Another type is TIME_BASED.
     * 4) ‘minimum-number-of-calls=5‘ indicates that we need at least 5 calls to calculate the failure
     *      rate threshold.
     * 5) ‘automatic-transition-from-open-to-half-open-enabled=true‘ indicates that don’t switch
     *      directly from the open state to the closed state, consider the half-open state also.
     * 6) ‘permitted-number-of-calls-in-half-open-state=4‘ indicates that when on half-open state,
     *      consider sending 4 requests. If 80% of them are failing, switch circuit breaker to open state.
     * 7) ‘wait-duration-in-open-state=1s’ indicates the waiting time interval while switching from
     *      the open state to the closed state.
     */
}
