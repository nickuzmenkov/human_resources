package com.example.hr.employee.dto;

import com.example.hr.employee.model.Department;
import com.example.hr.employee.model.Grade;

public class CreateEmployeeDto {
    private String firstName;
    private String lastName;
    private Department department;
    private Grade grade;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
