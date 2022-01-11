package project.employeeapi.employeeapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.employeeapi.employeeapi.dto.MessageResponseDTO;
import project.employeeapi.employeeapi.dto.request.EmployeeDTO;
import project.employeeapi.employeeapi.entity.Employee;
import project.employeeapi.employeeapi.service.EmployeeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }
}
