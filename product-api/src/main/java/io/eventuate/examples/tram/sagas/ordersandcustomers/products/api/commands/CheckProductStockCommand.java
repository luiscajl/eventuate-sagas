package io.eventuate.examples.tram.sagas.ordersandcustomers.products.api.commands;

import io.eventuate.tram.commands.common.Command;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CheckProductStockCommand implements Command {

    private long productId;

    private long quantity;

    public CheckProductStockCommand() {
    }

    public CheckProductStockCommand(long productId, long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
