package io.eventuate.examples.tram.sagas.ordersandcustomers.products.service;

import io.eventuate.examples.tram.sagas.ordersandcustomers.products.api.replies.ProductNotFound;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.domain.Product;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.domain.ProductNotFoundException;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.domain.ProductRepository;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.domain.ProductStockExceedException;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.webapi.CreateProductRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;


@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(CreateProductRequest request) {
        Product product = new Product(request.getStock(), request.getName(), request.getPrice());
        return productRepository.save(product);
    }

    public Product reserveStock(long quantity, long productId) {
        Optional<Product> optProduct = productRepository.findById(productId);
        if (optProduct.isPresent()) {
            if (optProduct.get().getStock() >= quantity) {
                optProduct.get().setStock(optProduct.get().getStock() - quantity);
                return productRepository.save(optProduct.get());
            } else {
                throw new ProductStockExceedException();
            }
        } else {
            throw new ProductNotFoundException();
        }
    }
}
