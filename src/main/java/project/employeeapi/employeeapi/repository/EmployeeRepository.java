package project.employeeapi.employeeapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.employeeapi.employeeapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
