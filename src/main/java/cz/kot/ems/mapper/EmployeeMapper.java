package cz.kot.ems.mapper;

import cz.kot.ems.dto.EmployeeDto;
import cz.kot.ems.entity.Employee;

/**
 * Mapper - converts JPA entities into Dtos and vice versa
 */
public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
