package stu.learning.kafka.productpoller.event;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class ProductPriceChangedEvent extends BaseEvent {

    private final String productId;
    private final BigDecimal price;

    public ProductPriceChangedEvent( String productId, BigDecimal price, UUID eventId, Instant timeStamp) {
        super(eventId, timeStamp);
        this.price = price;
        this.productId=productId;
    }

    //region getters
    public String getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }
    //endregion

    @Override
    public String toString() {
        return "ProductPriceChangedEvent{" +
                "productId='" + productId + '\'' +
                ", price=" + price +
                ", correlationId=" + correlationId +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
