package com.example.personapi.DTO.requests;

import com.example.personapi.enuns.CategoryType;
import com.example.personapi.enuns.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @NotEmpty
    @Size(min = 4,max = 7)
    private Integer salary;

}
