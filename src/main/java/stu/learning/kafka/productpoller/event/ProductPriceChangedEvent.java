package stu.learning.kafka.productpoller.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class ProductPriceChangedEvent extends BaseEvent {

    private final String productId;
    private final BigDecimal newPrice;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ProductPriceChangedEvent(
            @JsonProperty("productId") String productId,
            @JsonProperty("price") BigDecimal newPrice,
            @JsonProperty("correlationId") UUID correlationId,
            @JsonProperty("timeStamp") Instant timeStamp
    ) {
        super(correlationId, timeStamp);
        this.newPrice = newPrice;
        this.productId=productId;
    }

    //region getters
    public String getProductId() {
        return productId;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }
    //endregion

    @Override
    public String toString() {
        return "ProductPriceChangedEvent{" +
                "productId='" + productId + '\'' +
                ", price=" + newPrice +
                ", correlationId=" + correlationId +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
