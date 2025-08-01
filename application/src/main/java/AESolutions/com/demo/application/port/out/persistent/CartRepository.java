package AESolutions.com.demo.application.port.out.persistent;

import AESolutions.com.demo.model.cart.Cart;
import AESolutions.com.demo.model.customer.CustomerId;

import java.util.Optional;

public interface CartRepository {
    Optional<Cart> findByCustomerId(CustomerId customerId);
}
