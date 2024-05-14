package smr.shop.cart.service.helper;

import org.springframework.stereotype.Component;
import smr.shop.libs.grpc.coupon.CouponDiscountType;
import smr.shop.libs.grpc.coupon.CouponGrpcResponse;
import smr.shop.libs.grpc.product.ProductGrpcResponse;

@Component
public class CartServiceHelper {

    public double calculateCouponDiscountPrice(ProductGrpcResponse product, CouponGrpcResponse couponDetail) {
        double newPrice;
        if (couponDetail.getCouponTypeValue() == CouponDiscountType.AMOUNT_VALUE) {
            newPrice = product.getPrice() - couponDetail.getAmount();
        } else {
            double amount = (product.getPrice() / 100) * couponDetail.getPercentage();
            if (amount > couponDetail.getMaxDiscountPrice()) {
                newPrice = product.getPrice() - couponDetail.getMaxDiscountPrice();
            } else {
                newPrice = product.getPrice() - amount;
            }
        }
        return newPrice;
    }


}
