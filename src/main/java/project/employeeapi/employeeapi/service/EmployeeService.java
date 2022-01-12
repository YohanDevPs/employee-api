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
        return createMethodResponse(savedEmployee.getId(), "Created employee if ID ");
    }


    public List<EmployeeDTO> listAll() {
        List<Employee> allEmployee = employeeRepository.findAll();
        return allEmployee.stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO findById(Long id) throws EmployeeNotFoundException {
        Employee employee = verifyIfExists(id);
        return employeeMapper.toDTO(employee);
    }

    public void delete(Long id) throws EmployeeNotFoundException {
        employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));

        employeeRepository.deleteById(id);
    }

    public MessageResponseDTO updateBYId(Long id, EmployeeDTO employeeDTO) throws EmployeeNotFoundException {
        verifyIfExists(id);

        Employee employeeToUpdate = employeeMapper.toModel(employeeDTO);

        Employee updatedEmployee = employeeRepository.save(employeeToUpdate);
        return createMethodResponse(updatedEmployee.getId(), "Updated employee with ID ");
    }

    private Employee verifyIfExists(Long id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    private MessageResponseDTO createMethodResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
