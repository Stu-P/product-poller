package stu.learning.kafka.productpoller.persistence;

import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import stu.learning.kafka.productpoller.model.Product;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM product WHERE id = #{id}")
    @Results(value = {
            @Result(property = "deliveryPrice", column = "delivery_price")
    })
    Product getProduct(@Param("id") String id);

    @Insert("Insert into product(id, name, description, delivery_price, price) values (#{id}, #{name}, #{description}, #{deliveryPrice}, #{price})")
    public Integer createProduct(Product product);

    @Update("Update product set price=#{newPrice} where id=#{productId}")
    public void updatePrice(String productId, BigDecimal newPrice);
}