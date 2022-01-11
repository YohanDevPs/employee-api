package project.employeeapi.employeeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.employeeapi.employeeapi.dto.MessageResponseDTO;
import project.employeeapi.employeeapi.dto.request.EmployeeDTO;
import project.employeeapi.employeeapi.entity.Employee;
import project.employeeapi.employeeapi.mapper.EmployeeMapper;
import project.employeeapi.employeeapi.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public MessageResponseDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employeeToSave = employeeMapper.toModel(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employeeToSave);
        return MessageResponseDTO
                .builder()
                .message("Created employee if ID "+ savedEmployee.getId())
                .build();
    }

}
