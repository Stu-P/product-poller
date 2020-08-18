package stu.learning.kafka.productpoller.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.UUID;

public abstract class BaseEvent {
    protected final UUID correlationId;
    protected final Instant timeStamp;

    public BaseEvent(UUID correlationId, Instant timeStamp) {
        this.correlationId = correlationId;
        this.timeStamp = timeStamp;
    }

    public UUID getCorrelationId() {
        return correlationId;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }


}

