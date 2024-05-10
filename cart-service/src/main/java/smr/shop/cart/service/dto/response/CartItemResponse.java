package smr.shop.cart.service.dto.response;

import lombok.Builder;
import lombok.Value;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 5/10/2024
 * Time: 1:14 PM
 */
@Value
@Builder
public class CartItemResponse {

    Long productId;

    String name;

    Integer quantity;

    Double unitPrice;

    Double totalPrice;

    Double discountPrice;

    String attributeName;

    String thumbnail;

}
