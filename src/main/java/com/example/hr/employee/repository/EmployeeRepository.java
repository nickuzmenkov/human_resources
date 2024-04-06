package com.example.hr.employee.repository;

import com.example.hr.employee.dto.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDto, Long> {
}
