package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee= new Employee();
        employee.setEmployeeId(rs.getLong(1));
        employee.setFirstName(rs.getString(2));
        employee.setGender( Gender.valueOf(rs.getString(3)));
        return employee;
    }
}
