package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee createEmployee(Employee emp) {

        String SQL = "INSERT INTO employees (employeeId, firstName, lastName,"
                + " departmentId, jobTitle, gender, dateOfBirth) "+
                " VALUES (?,?,?,?,?,?,?)";

        jdbcTemplate.update(SQL, emp.getEmployeeId(), emp.getFirstName(),
                String.valueOf(emp.getGender()));
        System.out.println("Employee successfully created.\n" +emp.toString());
        return emp;
    }

    public Long deleteEmployeeById(Long employeeId) {
        String SQL = "DELETE FROM employees WHERE employeeId = ?";
        jdbcTemplate.update(SQL, employeeId);
        return employeeId;
    }

    public Employee findEmployeeById(Long employeeId) {
        String SQL = "SELECT * FROM employees WHERE employeeId = ?";
        return jdbcTemplate.queryForObject(SQL, new EmployeeMapper(),
                employeeId );
    }

    public Employee updateEmployeeById(Long employeeId, Employee emp){

        String SQL = "UPDATE employees SET firstName=?, lastName=?, "
                + "departmentId=?, jobTitle=?, gender=?,  dateOfBirth=? "
                + " WHERE employeeId =?";

        jdbcTemplate.update(SQL, emp.getFirstName(), String.valueOf(emp.getGender()),emp.getEmployeeId());

        System.out.println("Employee with employeeId: " +
                emp.getEmployeeId() + "was successfully updated.");
        return emp;
    }

    public List<Employee> listOfEmployees() {
        String SQL = "SELECT * FROM employees";
        List<Employee>employees = jdbcTemplate.query(SQL, new EmployeeMapper());
        return employees;
    }
}
