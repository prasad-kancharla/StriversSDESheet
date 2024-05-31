package com.prasad.companies.amazon.lld.strategy;

public class FixedShippingFeeCalculator implements ShippingFeeCalculator{
    private final int shippingFee;

    public FixedShippingFeeCalculator (int shippingFee) {
        this.shippingFee = shippingFee;
    }

    @Override
    public int calculateShippingFee(int price) {
        return shippingFee;
    }

}
