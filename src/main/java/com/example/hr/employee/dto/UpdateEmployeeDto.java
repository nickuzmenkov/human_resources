package com.example.hr.employee.dto;

import com.example.hr.employee.model.Department;
import com.example.hr.employee.model.Grade;

public class UpdateEmployeeDto {
    private Department department;
    private Grade grade;

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
