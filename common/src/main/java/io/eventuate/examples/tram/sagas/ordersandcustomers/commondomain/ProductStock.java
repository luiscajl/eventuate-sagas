package io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Access(AccessType.FIELD)
public class ProductStock {

    private Long productId;
    private Long quantity;

    public ProductStock() {
    }

    public ProductStock(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductStock{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
