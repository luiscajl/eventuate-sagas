package io.eventuate.examples.tram.sagas.ordersandcustomers.products.service;

import io.eventuate.examples.tram.sagas.ordersandcustomers.products.api.commands.CheckProductStockCommand;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.api.replies.ProductNotFound;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.api.replies.ProductStockExceeded;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.api.replies.ProductStockReserved;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.domain.ProductNotFoundException;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.domain.ProductStockExceedException;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import org.springframework.stereotype.Component;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;


@Component
public class ProductCommandHandler {

    private ProductService productService;

    public ProductCommandHandler(ProductService productService) {
        this.productService = productService;
    }

    public CommandHandlers commandHandlerDefinitions() {
        return SagaCommandHandlersBuilder
                .fromChannel("productService")
                .onMessage(CheckProductStockCommand.class, this::reserveCredit)
                .build();
    }

    public Message reserveCredit(CommandMessage<CheckProductStockCommand> cm) {
        CheckProductStockCommand cmd = cm.getCommand();
        try {
            productService.reserveStock(cmd.getQuantity(), cmd.getProductId());
            return withSuccess(new ProductStockReserved());
        } catch (ProductNotFoundException e) {
            return withFailure(new ProductNotFound());
        } catch (ProductStockExceedException e) {
            return withFailure(new ProductStockExceeded());
        }
    }
}
