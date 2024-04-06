package com.example.hr.employee.controller;

import com.example.hr.employee.dto.CreateEmployeeDto;
import com.example.hr.employee.dto.EmployeeDto;
import com.example.hr.employee.dto.UpdateEmployeeDto;
import com.example.hr.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    ResponseEntity<EmployeeDto> createEmployee(@RequestBody CreateEmployeeDto createEmployeeDto) {
        EmployeeDto employeeDto = employeeService.createEmployee(createEmployeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDto);
    }

    @GetMapping
    ResponseEntity<List<EmployeeDto>> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("/{employeeId}")
    ResponseEntity<EmployeeDto> getEmployee(@PathVariable long employeeId) {
        Optional<EmployeeDto> employeeDto = employeeService.getEmployee(employeeId);
        return employeeDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{employeeId}")
    ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long employeeId, @RequestBody UpdateEmployeeDto updateEmployeeDto) {
        Optional<EmployeeDto> employeeDto = employeeService.updateEmployee(employeeId, updateEmployeeDto);
        return employeeDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{employeeId}")
    ResponseEntity<Void> deleteEmployee(@PathVariable long employeeId) {
        boolean deleted = employeeService.deleteEmployee(employeeId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
