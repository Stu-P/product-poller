package stu.learning.kafka.productpoller.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal deliveryPrice;

    public Product(){}

    public Product(String id, String name, String description, BigDecimal price, BigDecimal deliveryPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.deliveryPrice = deliveryPrice;
    }

    // region getters/setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }
    // endregion getters/setters

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", deliveryPrice=" + deliveryPrice +
                '}';
    }
}
