package AESolutions.com.demo.model.cart;

import AESolutions.com.demo.model.product.Product;
import AESolutions.com.demo.model.product.TestProductFactory;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {
    @Test
    void shouldCalculateTotalQuantityAndPrice_whenTwoProductsAddedToCart1()
            throws IllegalArgumentException{

        Cart cart = TestCartFactory.emptyCartForRandomCustomer();

        // Create two products with integer prices to avoid floating-point precision issues
        Product product1 = TestProductFactory.createProduct(61);
        Product product2 = TestProductFactory.createProduct(19);

        cart.addProduct(product1, 13);
        cart.addProduct(product2, 17);

        assertThat(cart.numberOfItems()).isEqualTo(30);
        assertThat(cart.subTotal()).isEqualTo(1116);
    }

    @Test
    void shouldCalculateTotalQuantityAndPrice_whenTwoProductsAddedToCart2()
            throws IllegalArgumentException{
        Cart cart = TestCartFactory.emptyCartForRandomCustomer();

        //Create 2 products with double prices to check floating-point precision issues
        Product product1 = TestProductFactory.createProduct(9.99);
        Product product2 = TestProductFactory.createProduct(8.12);

        cart.addProduct(product1, 19);
        cart.addProduct(product2, 5);

        assertThat(cart.numberOfItems()).isEqualTo(24);
        assertThat(cart.subTotal()).isEqualTo(230.41);
    }
}
