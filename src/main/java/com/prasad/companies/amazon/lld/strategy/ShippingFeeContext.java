package com.prasad.companies.amazon.lld.strategy;

public class ShippingFeeContext {
    private ShippingFeeCalculator shippingFeeCalculator;

    public ShippingFeeContext(ShippingFeeCalculator shippingFeeCalculator) {
        this.shippingFeeCalculator = shippingFeeCalculator;
    }

    public int getShippingFee(int price) {
        return shippingFeeCalculator.calculateShippingFee(price);
    }
}
