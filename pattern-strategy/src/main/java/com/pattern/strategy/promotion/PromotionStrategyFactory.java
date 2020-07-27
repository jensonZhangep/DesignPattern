package com.pattern.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<String, PromotionStrategy>();
    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK.toString(), new CashBackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON.toString(), new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY.toString(), new GroupButStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.DEFAULT.toString(), new EmptyStrategy());
    }

    private PromotionStrategyFactory() throws Exception {
        throw new Exception("禁止非法实例化该类");
    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? PROMOTION_STRATEGY_MAP.get(PromotionKey.DEFAULT.toString()) : promotionStrategy;
    }
}
