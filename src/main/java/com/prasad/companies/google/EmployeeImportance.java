package com.prasad.companies.google;

import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/employee-importance/description/
class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        int numberOfEmployees = employees.size();
        HashMap<Integer, Employee> idEmployeeMap = new HashMap<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            Employee currentEmployee = employees.get(i);
            idEmployeeMap.put(currentEmployee.id, currentEmployee);
        }
        return calculateTotalImportance(id, idEmployeeMap);
    }

    private int calculateTotalImportance(int id, HashMap<Integer, Employee> idEmployeeMap) {
        Employee currentEmployee = idEmployeeMap.get(id);
        int totalImportance = currentEmployee.importance;
        for (int subOrdinate : currentEmployee.subordinates) {
            totalImportance += calculateTotalImportance(subOrdinate, idEmployeeMap);
        }
        return totalImportance;
    }

    class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;

    }

}