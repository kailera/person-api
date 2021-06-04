package com.example.personapi.services;


import com.example.personapi.DTO.MessageResponseDTO;
import com.example.personapi.DTO.requests.PersonDTO;
import com.example.personapi.entities.Person;
import com.example.personapi.mappers.PersonMapper;
import com.example.personapi.repositories.PersonRepository;
import com.example.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.personapi.utils.PersonUtils.createFakeDTO;
import static com.example.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage(){
        PersonDTO personDTO = createFakeDTO();
        Person expectedCreatedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedCreatedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedCreatedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedCreatedPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Create Person with id: " + savedPersonId)
                .build();
    }


}
