package com.prasad.companies.amazon.lld.builder;

public class Main {

    public static void main(String[] args) {
        Phone dreamPhone = new Phone.PhoneBuilder().setWarrantyInMonths(12)
                .setModel("Galaxy Z flip")
                .setBrand("Samsung")
                .setPrice(75000)
                .setWeight(160)
                .setDisplaySize(6.7)
                .build();
        System.out.println(dreamPhone);
    }

}
