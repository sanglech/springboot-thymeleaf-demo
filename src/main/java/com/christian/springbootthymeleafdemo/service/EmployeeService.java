package com.christian.springbootthymeleafdemo.service;

import com.christian.springbootthymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee getEmployeeById( int id);
    public void saveEmployee(Employee theEmployee);
    public void deleteEmployeeById(int theId);
}
