package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public ResponseEntity listOfEmployees(){
        List<Employee> employees= service.listOfEmployees();
        if(employees==null){
            return new ResponseEntity("No Employee found in List: "
                    + employees, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(employees,HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity findEmployeeById(@PathVariable("id") long id){
        Employee employee = service.findEmployeeById(id);
        if(employee==null){
            return new ResponseEntity("No Employee found for id: "
                    + id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(employee,HttpStatus.OK);
    }

    @PostMapping(value = "/employees")
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        service.createEmployee(employee);
        return new ResponseEntity(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") long id){
        if(null== service.deleteEmployeeById(id)){
            return new ResponseEntity("No Employee found for id: " + id,
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id,HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity updateCustomers(@PathVariable("id") long id,
                                          @RequestBody Employee employee){
        employee = service.updateEmployeeById(id, employee);
        if(employee==null){
            return new ResponseEntity("No Customer found for id: " + id,
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(employee,HttpStatus.OK);
    }
}
