package AESolutions.com.demo.model.product;

public class TestProductFactory {
    public static Product createProduct(double price) {
        return new Product(
            ProductId.randomProductId(),"name","desc", price, Integer.MAX_VALUE
        );
    }
}
