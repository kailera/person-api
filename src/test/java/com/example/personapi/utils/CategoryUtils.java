package com.example.personapi.utils;

import com.example.personapi.DTO.requests.CategoryDTO;
import com.example.personapi.entities.Category;
import com.example.personapi.enuns.CategoryType;
import com.example.personapi.enuns.Department;

public class CategoryUtils {
    // create fake datasets
    // static doesnt need instance or var, invokes any method directly
    private static final Department DEPARTMENT = Department.FINANCES;
    private static final CategoryType CATEGORY_TYPE = CategoryType.A1;
    private static final Integer SALARY = 1000;
    private static final Long ID_CATEGORY = 1L;

    // fake entities methods

    public static CategoryDTO createFakeDTO(){
        return CategoryDTO
                .builder()
                .department(DEPARTMENT)
                .categoryType(CATEGORY_TYPE)
                .salary(SALARY)
                .build();
    }

    public static Category createFakeEntity(){
        return Category
                .builder()
                .Id(ID_CATEGORY)
                .department(DEPARTMENT)
                .categoryType(CATEGORY_TYPE)
                .salary(SALARY)
                .build();
    }

}
