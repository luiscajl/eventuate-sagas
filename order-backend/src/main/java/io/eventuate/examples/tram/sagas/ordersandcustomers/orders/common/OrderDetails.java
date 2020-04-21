package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.common;

import io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain.Money;
import io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain.ProductStock;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class OrderDetails {

  private Long customerId;

  @Embedded
  private ProductStock productStock;

  @Embedded
  private Money orderTotal;


  public OrderDetails() {
  }

  public OrderDetails(Long customerId, Money orderTotal, ProductStock productStock) {
    this.customerId = customerId;
    this.orderTotal = orderTotal;
    this.productStock=productStock;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public Money getOrderTotal() {
    return orderTotal;
  }

  public ProductStock getProductStock() {
    return productStock;
  }
}
