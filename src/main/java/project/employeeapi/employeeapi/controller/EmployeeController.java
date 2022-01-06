package project.employeeapi.employeeapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/employee")
public class EmployeeController {

    @GetMapping
    public String getBook(){

        return "API test!";
    }
}
