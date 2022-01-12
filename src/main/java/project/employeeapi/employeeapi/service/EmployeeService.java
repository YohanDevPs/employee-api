package project.employeeapi.employeeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.employeeapi.employeeapi.dto.MessageResponseDTO;
import project.employeeapi.employeeapi.dto.request.EmployeeDTO;
import project.employeeapi.employeeapi.entity.Employee;
import project.employeeapi.employeeapi.exception.EmployeeNotFoundException;
import project.employeeapi.employeeapi.mapper.EmployeeMapper;
import project.employeeapi.employeeapi.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public MessageResponseDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employeeToSave = employeeMapper.toModel(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employeeToSave);
        return MessageResponseDTO
                .builder()
                .message("Created employee if ID " + savedEmployee.getId())
                .build();
    }


    public List<EmployeeDTO> listAll() {
        List<Employee> allEmployee = employeeRepository.findAll();
        return allEmployee.stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO findById(Long id) throws EmployeeNotFoundException {
        Employee employee = verifyOfExists(id);
        return employeeMapper.toDTO(employee);
    }

    private Employee verifyOfExists(Long id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public void delete(Long id) throws EmployeeNotFoundException {
        employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));

        employeeRepository.deleteById(id);
    }
}
