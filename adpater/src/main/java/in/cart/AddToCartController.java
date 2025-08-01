package in.cart;

import AESolutions.com.demo.application.port.in.AddToCartUseCase;
import AESolutions.com.demo.model.cart.Cart;
import AESolutions.com.demo.model.customer.CustomerId;
import AESolutions.com.demo.model.product.ProductId;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/carts")
@Produces(MediaType.APPLICATION_JSON)
public class AddToCartController {
    private final AddToCartUseCase addToCartUseCase;
    public AddToCartController(AddToCartUseCase addToCartUseCase) {
        this.addToCartUseCase = addToCartUseCase;
    }

    @POST
    @Path("/{customerId}/line-items")
    public void addLineItem(
            @PathParam("customerId") String customerIdString,
            @QueryParam("productId") String productIdString,
            @QueryParam("quantity") int quantity) {
        CustomerId customerId = parseCustomerId(customerIdString);
        ProductId productId = parseProductId(productIdString);

        try{
            Cart cart = addToCartUseCase.addToCart(customerId, productId, quantity);
            return;
        }
        catch (Exception ignored){

        }
    }

    private ProductId parseProductId(String productIdString) {
        return null;
    }

    private CustomerId parseCustomerId(String customerIdString) {
        return null;
    }
}
