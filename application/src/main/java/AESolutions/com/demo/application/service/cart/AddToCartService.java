package AESolutions.com.demo.application.service.cart;

import AESolutions.com.demo.application.port.in.AddToCartUseCase;
import AESolutions.com.demo.application.port.out.persistent.CartRepository;
import AESolutions.com.demo.application.port.out.persistent.ProductRepository;
import AESolutions.com.demo.model.cart.Cart;
import AESolutions.com.demo.model.customer.CustomerId;
import AESolutions.com.demo.model.product.Product;
import AESolutions.com.demo.model.product.ProductId;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AddToCartService implements AddToCartUseCase {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
//
    public AddToCartService(
            CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Cart addToCart(CustomerId customerId, ProductId productId, int quantity)
            throws IllegalArgumentException, ResponseStatusException {
        if(quantity<1){
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        Cart cart = cartRepository.findByCustomerId(customerId).orElseGet(()->new Cart(customerId));

        cart.addProduct(product, quantity);
        return cart;
    }
}
