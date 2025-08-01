package AESolutions.com.demo.model.cart;

import AESolutions.com.demo.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class CartLineItem {
    private final Product product;
    private int quantity;

    public void increaseQuantity(int amount, int itemsLeftInStock)
    {
        if (amount<1){
            throw new IllegalArgumentException("amount must be greater than 0");
        }
        int newQuantity = quantity + amount;
        if(newQuantity>itemsLeftInStock){
            throw new IllegalArgumentException(
                    String.format(
                            "Product %s has less items in stock (%d) than the requested total quantity (%d)",
                            product.id(), product.itemsLeftInStock(), newQuantity
                    )
            );
        }
        this.quantity = newQuantity;
    }
}
