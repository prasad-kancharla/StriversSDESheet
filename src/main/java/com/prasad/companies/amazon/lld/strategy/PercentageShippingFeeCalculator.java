package com.prasad.companies.amazon.lld.strategy;

public class PercentageShippingFeeCalculator implements ShippingFeeCalculator {

    private final int percentage;

    public PercentageShippingFeeCalculator(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public int calculateShippingFee(int price) {
        return (percentage * price)/100;
    }

}
