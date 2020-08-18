package stu.learning.kafka.productpoller.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import stu.learning.kafka.productpoller.model.Product;

import java.time.Instant;
import java.util.UUID;

public class ProductCreatedEvent extends BaseEvent {

    private final Product product;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ProductCreatedEvent(
            @JsonProperty("product") Product product,
            @JsonProperty("correlationId") UUID correlationId,
            @JsonProperty("timeStamp") Instant timeStamp) {

        super(correlationId, timeStamp);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ProductCreatedEvent{" +
                "product=" + product +
                ", correlationId=" + correlationId +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
