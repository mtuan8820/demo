package AESolutions.com.demo.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import javax.annotation.processing.Generated;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
public class Product {
    private final ProductId id;
    private String name;
    private String description;
    private double price;
    private int itemsLeftInStock; //number of items available in stock
}
