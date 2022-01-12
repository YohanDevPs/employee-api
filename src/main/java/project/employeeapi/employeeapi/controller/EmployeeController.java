package project.employeeapi.employeeapi.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.employeeapi.employeeapi.dto.MessageResponseDTO;
import project.employeeapi.employeeapi.dto.request.EmployeeDTO;
import project.employeeapi.employeeapi.exception.EmployeeNotFoundException;
import project.employeeapi.employeeapi.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> listAll(){
      return employeeService.listAll();
    };

    @GetMapping("/{id}")
    public  EmployeeDTO findById(@PathVariable Long id) throws EmployeeNotFoundException {
        return  employeeService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody @Valid EmployeeDTO employeeDTO) throws EmployeeNotFoundException {
        return employeeService.updateBYId(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws EmployeeNotFoundException {
        employeeService.delete(id);
    }
}
