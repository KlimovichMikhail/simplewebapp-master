package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao dao;

    @Override
    public Employee createEmployee(Employee employee) {
        return dao.createEmployee(employee);
    }

    @Override
    public Long deleteEmployeeById(Long employeeId) {
        return dao.deleteEmployeeById(employeeId);
    }

    @Override
    public Employee findEmployeeById(Long employeeId) {
        return dao.findEmployeeById(employeeId);
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        return dao.updateEmployeeById(id, employee);
    }

    @Override
    public List<Employee> listOfEmployees() {
        return dao.listOfEmployees();
    }
}
