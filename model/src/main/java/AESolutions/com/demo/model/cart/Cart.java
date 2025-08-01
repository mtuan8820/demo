package AESolutions.com.demo.model.cart;

import AESolutions.com.demo.model.customer.CustomerId;
import AESolutions.com.demo.model.product.Product;
import AESolutions.com.demo.model.product.ProductId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.Map;

@Accessors(fluent = true)
@RequiredArgsConstructor
public class Cart {
    @Getter
    private final CustomerId id;

    private final Map<ProductId, CartLineItem>lineItems = new LinkedHashMap<>();

    public void addProduct(Product product, int quantity) {
        lineItems
                .computeIfAbsent(product.id(), ignored-> new CartLineItem(product))
                .increaseQuantity(quantity, product.itemsLeftInStock());
    }

    public int numberOfItems() {
        return lineItems.values().stream().mapToInt(CartLineItem::quantity).sum();
    }

    public double subTotal() {
        return lineItems.values().stream()
                .mapToDouble(item -> item.quantity() * item.product().price())
                .sum();

    }
}
