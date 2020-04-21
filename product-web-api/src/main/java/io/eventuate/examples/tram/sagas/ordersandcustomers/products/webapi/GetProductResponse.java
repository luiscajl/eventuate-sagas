package io.eventuate.examples.tram.sagas.ordersandcustomers.products.webapi;

public class GetProductResponse {

    private Long id;

    private Long stock;

    private String name;

    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public GetProductResponse(Long id, Long stock, String name, Long price) {
        this.id = id;
        this.stock = stock;
        this.name = name;
        this.price = price;
    }
}
