package com.example.faultToleranceresilience4J.controller;

public interface ImpletementMultiplepatternInASingleMethod {

    /**
     * 1) Bulkhead
     * 2) Time Limiter.
     * 3) Rate Limiter.
     * 4) Circuit Breaker
     * 5) Retry
     */

    // ========================= properties file for multiple pattern in a single method ===============
    /**
     * resilience4j.bulkhead.bulkheadAspectOrder =1
     * resilience4j.timelimiter.timeLimiterAspectOrder =2
     * resilience4j.ratelimiter.rateLimiterAspectOrder =3
     * resilience4j.circuitbreaker.circuitBreakerAspectOrder =4
     * resilience4j.retry.retryAspectOrder =5
     */
}
