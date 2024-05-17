package smr.shop.shop.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class UpdateShopAddressRequest {
    @NotBlank String name;
    @NotBlank String street;
    @NotBlank String city;
    @NotBlank String state;
}
