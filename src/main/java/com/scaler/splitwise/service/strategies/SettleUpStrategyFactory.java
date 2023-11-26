package com.scaler.splitwise.service.strategies;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategy(SettleUpStrategy strategyName){
        return new HeapBasedSettleUpStrategies();
    }
}
