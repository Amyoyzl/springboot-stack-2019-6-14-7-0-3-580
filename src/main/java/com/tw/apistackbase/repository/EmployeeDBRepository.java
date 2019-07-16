package com.tw.apistackbase.repository;

import com.tw.apistackbase.modal.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDBRepository implements EmployeeRepository {
    private static Map<String, Employee> employees = new HashMap<>();

    static {
        employees.put("5555", new Employee("5555", "Jimmy", "Female", 9));
        employees.put("6666", new Employee("6666", "rose", "Female", 18));
        employees.put("7777", new Employee("7777", "John", "Male", 6));
        employees.put("8888", new Employee("8888", "Amy", "Female", 18));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee getById(String id) {
        return employees.get(id);
    }

    @Override
    public Employee add(Employee employee) {
        String id = UUID.randomUUID().toString();
        employee.setId(id);
        employees.put(id, employee);
        return employee;
    }

    @Override
    public Employee delete(String id) {
        return employees.remove(id);
    }

    @Override
    public Employee update(Employee employee, String id) {
        employees.remove(id);
        return employees.put(id, employee);
    }

    @Override
    public List<Employee> getEmployeesAbove(int ageMin) {
        return employees.values().stream().filter(employee -> employee.getAge() > ageMin).collect(Collectors.toList());
    }
}
