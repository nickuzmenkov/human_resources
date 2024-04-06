package com.example.hr.employee.service;

import com.example.hr.employee.dto.CreateEmployeeDto;
import com.example.hr.employee.dto.EmployeeDto;
import com.example.hr.employee.dto.UpdateEmployeeDto;
import com.example.hr.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto createEmployee(CreateEmployeeDto createEmployeeDto) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName(createEmployeeDto.getFirstName());
        employeeDto.setLastName(createEmployeeDto.getLastName());
        employeeDto.setDepartment(createEmployeeDto.getDepartment());
        employeeDto.setGrade(createEmployeeDto.getGrade());
        return employeeRepository.save(employeeDto);
    }

    public List<EmployeeDto> getEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeDto> getEmployee(long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public Optional<EmployeeDto> updateEmployee(long employeeId, UpdateEmployeeDto updateEmployeeDto) {
        return employeeRepository.findById(employeeId).map(employeeDto -> {
            employeeDto.setDepartment(updateEmployeeDto.getDepartment());
            employeeDto.setGrade(updateEmployeeDto.getGrade());
            return employeeRepository.save(employeeDto);
        });
    }

    public boolean deleteEmployee(long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        } else {
            return false;
        }
    }
}
