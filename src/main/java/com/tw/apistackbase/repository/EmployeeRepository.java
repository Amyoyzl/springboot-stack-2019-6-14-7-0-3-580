package com.tw.apistackbase.repository;

import com.tw.apistackbase.modal.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeRepository {

    private static Map<String, Employee> employees = new HashMap<>();

    static {
        employees.put("1111", new Employee("1111", "Jimmy", "Female", 9));
        employees.put("2222", new Employee("2222", "rose", "Female", 18));
        employees.put("3333", new Employee("3333", "John", "Male", 6));
        employees.put("4444", new Employee("4444", "Amy", "Female", 18));
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public Employee getById(String id) {
        return employees.get(id);
    }

    public Employee add(Employee employee) {
        String id = UUID.randomUUID().toString();
        employee.setId(id);
        employees.put(id, employee);
        return employee;
    }

    public Employee delete(String id) {
        return employees.remove(id);
    }

    public Employee update(Employee employee) {
        String id = employee.getId();
        employees.remove(id);
        return employees.put(id, employee);
    }

    public List<Employee> getAgeGreaterTenEmployees() {
        return new ArrayList<>(employees.values()).stream().filter(employee -> employee.getAge() > 10).collect(Collectors.toList());
    }

    public List<Employee> getEmployeesAbove(int ageMin) {
        return employees.values().stream().filter(employee -> employee.getAge() > ageMin).collect(Collectors.toList());
    }
}
