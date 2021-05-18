package com.mastery.java.task.dto;

public class Employee {
    private Long employeeId;
    private String firstName;
    private Gender gender;
}
    public Employee(){
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }
    public Gender getGender() {
        return gender;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
    }
