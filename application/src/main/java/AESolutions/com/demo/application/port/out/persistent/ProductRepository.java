package AESolutions.com.demo.application.port.out.persistent;

import AESolutions.com.demo.model.product.Product;
import AESolutions.com.demo.model.product.ProductId;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(ProductId id);
}
