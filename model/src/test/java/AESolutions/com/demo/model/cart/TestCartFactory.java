package AESolutions.com.demo.model.cart;

import AESolutions.com.demo.model.customer.CustomerId;


public class TestCartFactory {
    public static Cart emptyCartForRandomCustomer() {
        return new Cart(new CustomerId(1));
    }
}