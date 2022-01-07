package project.employeeapi.employeeapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.employeeapi.employeeapi.dto.MessageResponseDTO;
import project.employeeapi.employeeapi.entity.Employee;
import project.employeeapi.employeeapi.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v2/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    @PostMapping
    public MessageResponseDTO createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeRepository.save(employee);
        return MessageResponseDTO
                .builder()
                .message("Created employee if ID"+ savedEmployee.getId())
                .build();
    }
}
