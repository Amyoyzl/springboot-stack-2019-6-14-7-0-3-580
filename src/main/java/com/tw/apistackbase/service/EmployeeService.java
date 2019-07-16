package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(String id) {
        return employeeRepository.getById(id);
    }

    public Employee add(Employee employee) {
        return employeeRepository.add(employee);
    }

    public Employee delete(String id) {
        return employeeRepository.delete(id);
    }

    public Employee update(Employee employee, String id) {
        return employeeRepository.update(employee, id);
    }

    public List<Employee> getEmployeesAbove(int ageMin) {
        return employeeRepository.getEmployeesAbove(ageMin);
    }
}
