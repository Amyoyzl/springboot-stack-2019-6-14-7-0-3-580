package com.tw.apistackbase.repository;

import com.tw.apistackbase.modal.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {
    List<Employee> findAll();

    Employee getById(String id);

    Employee add(Employee employee);

    Employee delete(String id);

    Employee update(Employee employee, String id);

    List<Employee> getEmployeesAbove(int ageMin);
}
