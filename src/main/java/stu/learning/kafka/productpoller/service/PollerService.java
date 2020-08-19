package stu.learning.kafka.productpoller.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import stu.learning.kafka.productpoller.event.ProductCreatedEvent;
import stu.learning.kafka.productpoller.event.ProductPriceChangedEvent;
import stu.learning.kafka.productpoller.persistence.ProductMapper;

import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_PARTITION_ID;

import java.io.IOException;


@Service
@KafkaListener(topics = "product-topic", groupId = "product-poller-group")
public class PollerService {

    Logger logger = LoggerFactory.getLogger(PollerService.class);

    private final ProductMapper productMapper;

    @Autowired
    public PollerService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @KafkaHandler
    public void consume(ProductCreatedEvent event, @Header(RECEIVED_PARTITION_ID) Integer partitionId) throws IOException {
        logger.info("#### -> Consumed create product message -> {} from partition {}", event, partitionId);
        try {
            productMapper.createProduct(event.getProduct());
        } catch (Exception ex) {
            logger.error("Error writing product to db. {} | {}", ex.getMessage(), ex.getCause());
        }
    }

    @KafkaHandler
    public void consume(ProductPriceChangedEvent event) throws IOException {
        logger.info(String.format("#### -> Consumed price changed message -> %s", event));
        try {
            productMapper.updatePrice(event.getProductId(), event.getNewPrice());
        } catch (Exception ex) {
            logger.error("Error writing updated price to db. {} | {}", ex.getMessage(), ex.getCause());
        }
    }
}
