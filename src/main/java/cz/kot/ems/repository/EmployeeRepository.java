package cz.kot.ems.repository;

import cz.kot.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository - communicates with the database
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
