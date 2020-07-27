package com.pattern.strategy.promotion;

public class CashBackStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("返现促销");
    }
}
