package io.eventuate.examples.tram.sagas.ordersandcustomers.products.webapi;

import lombok.Data;
import lombok.Getter;


public class CreateProductRequest {
  private Long price;
  private Long stock;
  private String name;

  public Long getPrice() {
    return price;
  }

  public Long getStock() {
    return stock;
  }

  public String getName() {
    return name;
  }

  public CreateProductRequest() {
  }

  public CreateProductRequest(Long price, Long stock, String name) {
    this.price = price;
    this.stock = stock;
    this.name = name;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public void setStock(Long stock) {
    this.stock = stock;
  }

  public void setName(String name) {
    this.name = name;
  }
}
