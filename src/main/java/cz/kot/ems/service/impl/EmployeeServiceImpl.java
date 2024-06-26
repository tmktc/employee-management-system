package cz.kot.ems.service.impl;

import cz.kot.ems.dto.EmployeeDto;
import cz.kot.ems.entity.Employee;
import cz.kot.ems.exception.ResourceNotFoundException;
import cz.kot.ems.mapper.EmployeeMapper;
import cz.kot.ems.repository.EmployeeRepository;
import cz.kot.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class - business logic
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id '" + employeeId + "' does not exist"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .sorted(Comparator.comparing(EmployeeDto::getId))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(int employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id '" + employeeId + "' does not exist")
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id '" + employeeId + "' does not exist")
        );

        employeeRepository.deleteById(employeeId);
    }
}
