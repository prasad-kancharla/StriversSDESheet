package com.prasad.companies.amazon;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SalaryCalculator {

    public static void main(String[] args) {
        
    }

    private Map<Integer, Integer> getSalary(LocalDate startDate, int baseSalaryPerYear, int rsuPerYear, int signOnBonus) {
        Map<Integer, Integer> salaryPerYearMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int year = i + startDate.getYear();
            int monthsInCurrentYear = i == 0 ? 12 - startDate.getMonthValue() : 12;
            int salary = (baseSalaryPerYear/12 + rsuPerYear/12) * monthsInCurrentYear;
            if (i == 0) salary += signOnBonus;
            salaryPerYearMap.put(year, salary);
        }
        return salaryPerYearMap;
    }
}
