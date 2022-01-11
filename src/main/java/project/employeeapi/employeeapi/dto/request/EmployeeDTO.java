package project.employeeapi.employeeapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import project.employeeapi.employeeapi.entity.Contact;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;


    @NotEmpty
    @Size(max = 30)
    private String firstName;

    @NotEmpty
    @Size(max = 30)
    private  String lastName;

    @NotEmpty
    @Size(max = 50)
    private String specialty;

    private  String cpf;

    private LocalDate birthDate;

    @Valid
    @NotEmpty
    private List<Contact> contacts;

}
