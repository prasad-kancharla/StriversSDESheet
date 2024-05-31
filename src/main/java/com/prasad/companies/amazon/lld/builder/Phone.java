package com.prasad.companies.amazon.lld.builder;

public class Phone {

    private String model;
    private int price;
    private String brand;
    private int warrantyInMonths;
    private int weight;
    private double displaySize;

    private Phone(String model, int price, String brand, int warrantyInMonths, int weight, double displaySize) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.weight = weight;
        this.warrantyInMonths = warrantyInMonths;
        this.displaySize = displaySize;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", warrantyInMonths=" + warrantyInMonths +
                ", weight=" + weight +
                ", displaySize=" + displaySize +
                '}';
    }

    static class PhoneBuilder {

        private String model;
        private int price;
        private String brand;
        private int warrantyInMonths;
        private int weight;
        private double displaySize;

        public PhoneBuilder() {

        }

        public PhoneBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public PhoneBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public PhoneBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public PhoneBuilder setWarrantyInMonths(int warrantyInMonths) {
            this.warrantyInMonths = warrantyInMonths;
            return this;
        }

        public PhoneBuilder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public PhoneBuilder setDisplaySize(double displaySize) {
            this.displaySize = displaySize;
            return this;
        }

        public Phone build() {
            return new Phone(this.model, this.price, this.brand, this.warrantyInMonths, this.weight, this.displaySize);
        }

    }

}
