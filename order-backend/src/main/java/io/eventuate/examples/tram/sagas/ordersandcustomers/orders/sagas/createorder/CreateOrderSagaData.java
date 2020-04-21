package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.createorder;

import io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain.ProductStock;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.common.OrderDetails;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.RejectionReason;

public class CreateOrderSagaData  {

  private OrderDetails orderDetails;
  private Long orderId;
  private ProductStock product;
  private RejectionReason rejectionReason;

  public CreateOrderSagaData(OrderDetails orderDetails) {
    this.orderDetails = orderDetails;
    this.product=orderDetails.getProductStock();
  }

  public CreateOrderSagaData() {
  }

  public Long getOrderId() {
    return orderId;
  }

  public OrderDetails getOrderDetails() {
    return orderDetails;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public void setRejectionReason(RejectionReason rejectionReason) {
    this.rejectionReason = rejectionReason;
  }

  public RejectionReason getRejectionReason() {
    return rejectionReason;
  }

  public ProductStock getProduct() {
    return product;
  }

  @Override
  public String toString() {
    return "CreateOrderSagaData{" +
            "orderDetails=" + orderDetails +
            ", orderId=" + orderId +
            ", product=" + product +
            ", rejectionReason=" + rejectionReason +
            '}';
  }
}
