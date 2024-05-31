package com.prasad.companies.amazon.lld.strategy;

public class Main {

    public static void main(String[] args) {
        int price = 1000;
        PercentageShippingFeeCalculator percentageShippingFeeCalculator = new PercentageShippingFeeCalculator(15);
        ShippingFeeContext shippingFeeContext = new ShippingFeeContext(percentageShippingFeeCalculator);
        System.out.println(shippingFeeContext.getShippingFee(price));
    }

}
