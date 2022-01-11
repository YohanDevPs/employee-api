package project.employeeapi.employeeapi.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.employeeapi.employeeapi.enums.ContactType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
