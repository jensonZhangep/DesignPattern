package com.pattern.strategy.promotion;

public class CouponStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("领取优惠券");
    }
}
