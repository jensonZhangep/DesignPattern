package com.pattern.strategy.promotion;

public class GroupButStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("团购");
    }
}
