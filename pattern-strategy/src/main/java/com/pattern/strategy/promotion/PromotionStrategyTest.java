package com.pattern.strategy.promotion;

public class PromotionStrategyTest {
    public static void main(String[] args) {
        PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(PromotionKey.CASHBACK.toString());
        promotionStrategy.doPromotion();
    }
}
