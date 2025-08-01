package AESolutions.com.demo.model.product;
import java.security.SecureRandom;

public record ProductId(String value) {
    private static final SecureRandom random = new SecureRandom();
    private static final int LENGTH_OF_PRODUCT_IDS = 8;
    public static ProductId randomProductId() {
        String chars = "0123456789";
        StringBuilder sb = new StringBuilder("PRD-"); //prefix for product id is PRD
        for (int i = 0; i < LENGTH_OF_PRODUCT_IDS; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return new ProductId(sb.toString());
    }
}
