package io.eventuate.examples.tram.sagas.ordersandcustomers.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

    @Value("${url.order}")
    private String ORDER_URL;

    @Value("${url.customer}")
    private String CUSTOMER_URL;

    @Value("${url.product}")
    private String PRODUCT_URL;

    @RequestMapping("/hystrixfallback")
    public String hystrixfallback() {
        return "This is a fallback";
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/orders/**").uri(ORDER_URL))
                .route(r -> r.path("/customers/**").uri(CUSTOMER_URL))
                .route(r -> r.path("/products/**").uri(PRODUCT_URL)).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}