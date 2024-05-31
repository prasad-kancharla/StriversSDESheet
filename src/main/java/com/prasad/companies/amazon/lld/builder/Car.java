package com.prasad.companies.amazon.lld.builder;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;

    private Car(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }

    public static class CarBuilder {
        private String make;
        private String model;
        private int year;
        private String color;

        public CarBuilder() {
        }

        public CarBuilder setMake(String make) {
            this.make = make;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(make, model, year, color);
        }
    }
}

