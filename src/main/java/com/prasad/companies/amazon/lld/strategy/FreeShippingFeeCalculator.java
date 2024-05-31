package com.prasad.companies.amazon.lld.strategy;

public class FreeShippingFeeCalculator implements ShippingFeeCalculator {

    public FreeShippingFeeCalculator() {

    }

    @Override
    public int calculateShippingFee(int price) {
        return 0;
    }

}
