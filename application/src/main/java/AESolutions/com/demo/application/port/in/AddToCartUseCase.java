package AESolutions.com.demo.application.port.in;

import AESolutions.com.demo.model.cart.Cart;
import AESolutions.com.demo.model.customer.CustomerId;
import AESolutions.com.demo.model.product.ProductId;

import org.springframework.web.server.ResponseStatusException;

public interface AddToCartUseCase {
    Cart addToCart(CustomerId customerId, ProductId productId, int quantity)
            throws IllegalArgumentException, ResponseStatusException;
}
