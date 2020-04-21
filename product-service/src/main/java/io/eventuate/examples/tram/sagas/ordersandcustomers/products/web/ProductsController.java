package io.eventuate.examples.tram.sagas.ordersandcustomers.products.web;


import io.eventuate.examples.tram.sagas.ordersandcustomers.products.domain.Product;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.domain.ProductRepository;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.service.ProductService;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.webapi.CreateProductRequest;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.webapi.CreateProductResponse;
import io.eventuate.examples.tram.sagas.ordersandcustomers.products.webapi.GetProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {

    private ProductService productService;

    private ProductRepository productRepository;

    public ProductsController(ProductService productService, ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @PostMapping(value = "/products")
    public CreateProductResponse createProduct(@RequestBody CreateProductRequest productRequest) {
        Product product = productService.createProduct(productRequest);
        return new CreateProductResponse(product.getId());
    }

    @GetMapping(value = "/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable Long productId) {
        return productRepository
                .findById(productId)
                .map(o -> new ResponseEntity<>(new GetProductResponse(o.getId(),o.getStock(),o.getName(),o.getPrice()), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
