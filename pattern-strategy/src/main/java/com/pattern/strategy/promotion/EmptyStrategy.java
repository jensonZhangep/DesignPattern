package com.pattern.strategy.promotion;

public class EmptyStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("没有活动");
    }
}
