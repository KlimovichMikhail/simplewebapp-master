package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Long deleteEmployeeById(Long employeeId);

    Employee findEmployeeById(Long employeeId);

    Employee updateEmployeeById(Long id, Employee employee);

    List<Employee> listOfEmployees();
}
