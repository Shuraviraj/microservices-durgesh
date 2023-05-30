package shuravi.userservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Breaker {

//    @Bean
//    public CircuitBreakerConfig circuitBreakerConfig() {
//        return CircuitBreakerConfig.custom()
//                .failureRateThreshold(50)
//                .waitDurationInOpenState(Duration.ofSeconds(6))
//                .permittedNumberOfCallsInHalfOpenState(3)
//                .slidingWindowSize(10)
//                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
//                .automaticTransitionFromOpenToHalfOpenEnabled(true)
//                .minimumNumberOfCalls(5)
//                .build();
//    }
//
//    @Bean
//    public CircuitBreakerRegistry circuitBreakerRegistry() {
//        return CircuitBreakerRegistry.of(circuitBreakerConfig());
//    }
//
//    @Bean
//    public CircuitBreaker circuitBreaker() {
//        return new
//                .circuitBreaker("name");
//    }

}
