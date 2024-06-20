package cz.kot.ems.service.impl;

import cz.kot.ems.dto.EmployeeDto;
import cz.kot.ems.entity.Employee;
import cz.kot.ems.mapper.EmployeeMapper;
import cz.kot.ems.repository.EmployeeRepository;
import cz.kot.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
