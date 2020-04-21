package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.webapi;


import io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain.Money;
import io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain.ProductStock;

public class CreateOrderRequest {
  private Money orderTotal;
  private Long customerId;
  private ProductStock productStock;

  public CreateOrderRequest() {
  }

  public CreateOrderRequest(Money orderTotal, Long customerId, ProductStock productStock) {
    this.orderTotal = orderTotal;
    this.customerId = customerId;
    this.productStock = productStock;
  }

  public Money getOrderTotal() {
    return orderTotal;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public ProductStock getProductStock() {
    return productStock;
  }
}
