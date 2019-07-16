package com.tw.apistackbase.controller;

import com.tw.apistackbase.modal.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> list() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.getById(id);
    }

    @GetMapping(path = "employees", params = "age")
    public List<Employee> getEmployeesAbove(@RequestParam("age") int ageMin) {
        return employeeService.getEmployeesAbove(ageMin);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable String id) {
        return employeeService.delete(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
        return employeeService.update(employee, id);
    }
}
