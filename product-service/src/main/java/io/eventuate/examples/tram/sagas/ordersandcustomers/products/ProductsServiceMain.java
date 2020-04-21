package io.eventuate.examples.tram.sagas.ordersandcustomers.products;

import io.eventuate.examples.tram.sagas.ordersandcustomers.products.ProductConfiguration;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.web.ProductsWebConfiguration;
import io.eventuate.tram.spring.commands.producer.TramCommandProducerConfiguration;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.spring.jdbckafka.TramJdbcKafkaConfiguration;
import io.eventuate.tram.messaging.common.ChannelMapping;
import io.eventuate.tram.messaging.common.DefaultChannelMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@Import({ProductsWebConfiguration.class,
        ProductConfiguration.class,
        TramEventsPublisherConfiguration.class,
        TramCommandProducerConfiguration.class,
        TramJdbcKafkaConfiguration.class})
public class ProductsServiceMain {

  @Bean
  public ChannelMapping channelMapping() {
    return DefaultChannelMapping.builder().build();
  }

  public static void main(String[] args) {
    SpringApplication.run(ProductsServiceMain.class, args);
  }

}
