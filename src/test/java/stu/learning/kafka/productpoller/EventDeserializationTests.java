package stu.learning.kafka.productpoller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import stu.learning.kafka.productpoller.event.ProductCreatedEvent;
import static org.junit.jupiter.api.Assertions.*;

public class EventDeserializationTests {

    @Test
    public void givenValidEventPayload_CanDeserializeToObject() throws JsonProcessingException {
        String payload = "{\"product\":{\"id\":\"353a3445-ab30-461a-8cea-b8e7cccf56fa\",\"name\":\"Huawei\",\"description\":\"string\",\"price\":4,\"deliveryPrice\":23},\"correlationId\":\"93a0014f-03da-4dfa-8257-bc9cf4b0b76a\",\"timeStamp\":1597629575.854422000}";


        var mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        ProductCreatedEvent actual = mapper.readValue(payload, ProductCreatedEvent.class);

        assertNotNull(actual);
        assertNotNull(actual.getProduct());
        assertEquals("Huawei",actual.getProduct().getName());
    }
}
