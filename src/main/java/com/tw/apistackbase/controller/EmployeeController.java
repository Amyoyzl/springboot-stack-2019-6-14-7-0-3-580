package com.tw.apistackbase.controller;

import com.tw.apistackbase.modal.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeRepository repository = new EmployeeRepository();

    @GetMapping("/employees")
    public List<Employee> list() {
        return repository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return repository.getById(id);
    }

    @GetMapping("/employees/greaterThanTen")
    public List<Employee> getAgeGreaterTenEmployees() {
        return repository.getAgeGreaterTenEmployees();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return repository.add(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable String id) {
        return repository.delete(id);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return repository.update(employee);
    }
}
