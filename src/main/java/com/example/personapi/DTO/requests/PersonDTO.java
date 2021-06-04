package com.example.personapi.DTO.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor // construtor
@NoArgsConstructor // contrutor vazio
public class PersonDTO {
    private Long id;

    @NotEmpty
    @Size(min = 1, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 1, max = 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;


    private CategoryDTO category;
}
