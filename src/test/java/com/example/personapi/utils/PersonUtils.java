package com.example.personapi.utils;

import com.example.personapi.DTO.requests.PersonDTO;
import com.example.personapi.entities.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final String FIST_NAME = "Samuel";
    private static final String LAST_NAME = "Ferreira";
    private static final String CPF_NUMBER = "nops";
    private static final Long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO(){
        return PersonDTO
                .builder()
                .firstName(FIST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .category(CategoryUtils.createFakeDTO())
                .build();
    }

    public static Person createFakeEntity(){
        return Person
                .builder()
                .id(PERSON_ID)
                .firstName(FIST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .category(CategoryUtils.createFakeEntity())
                .build();
    }
}
