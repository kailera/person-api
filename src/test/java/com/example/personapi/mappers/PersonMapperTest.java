package com.example.personapi.mappers;

import com.example.personapi.DTO.requests.CategoryDTO;
import com.example.personapi.DTO.requests.PersonDTO;
import com.example.personapi.DTO.requests.PhoneDTO;
import com.example.personapi.entities.Category;
import com.example.personapi.entities.Person;
import com.example.personapi.entities.Phone;
import com.example.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity(){
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person person = PersonUtils.createFakeEntity();

        assertEquals(personDTO.getFirstName(), person.getFirstName());
        assertEquals(personDTO.getLastName(), person.getLastName());
        assertEquals(personDTO.getCpf(), person.getCpf());

        //arrays
        Phone phone = person.getPhones().get(0);
        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        Category category = person.getCategory();
        CategoryDTO categoryDTO = personDTO.getCategory();

        assertEquals(phoneDTO.getType(), phone.getType());
        assertEquals(phoneDTO.getNumber(), phone.getNumber());

        assertEquals(categoryDTO.getDepartment(), category.getDepartment());
        assertEquals(categoryDTO.getCategoryType(),category.getCategoryType());
        assertEquals(categoryDTO.getSalary(),category.getSalary());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO(){
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person person = PersonUtils.createFakeEntity();

        assertEquals(person.getFirstName(), personDTO.getFirstName());
        assertEquals(person.getLastName(), personDTO.getLastName());
        assertEquals(person.getCpf(), personDTO.getCpf());

        //arrays
        Phone phone = person.getPhones().get(0);
        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        Category category = person.getCategory();
        CategoryDTO categoryDTO = personDTO.getCategory();

        assertEquals(phone.getType(), phoneDTO.getType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());

        assertEquals(category.getDepartment(), categoryDTO.getDepartment());
        assertEquals(category.getCategoryType(), categoryDTO.getCategoryType());
        assertEquals(category.getSalary(), categoryDTO.getSalary());
    }
}
