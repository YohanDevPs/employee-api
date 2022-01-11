package project.employeeapi.employeeapi.mapper;

import project.employeeapi.employeeapi.dto.request.EmployeeDTO;
import project.employeeapi.employeeapi.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Employee toModel(EmployeeDTO employeeDTO);

    EmployeeDTO toDTO(Employee employee);

}
