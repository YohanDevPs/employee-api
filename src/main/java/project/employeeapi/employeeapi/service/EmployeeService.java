package project.employeeapi.employeeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import project.employeeapi.employeeapi.dto.MessageResponseDTO;
import project.employeeapi.employeeapi.entity.Employee;
import project.employeeapi.employeeapi.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public MessageResponseDTO createEmployee(Employee employee){
        Employee savedEmployee = employeeRepository.save(employee);
        return MessageResponseDTO
                .builder()
                .message("Created employee if ID "+ savedEmployee.getId())
                .build();
    }

}
