package cz.kot.ems.service;

import cz.kot.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(int employeeId);

    List<EmployeeDto> getAllEmployees();
}
