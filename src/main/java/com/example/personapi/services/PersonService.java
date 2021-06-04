package com.example.personapi.services;

import com.example.personapi.DTO.MessageResponseDTO;
import com.example.personapi.DTO.requests.PersonDTO;
import com.example.personapi.entities.Person;
import com.example.personapi.exception.PersonNotFoundException;
import com.example.personapi.mappers.PersonMapper;
import com.example.personapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    // person repository possui todas as funcoes jpa para conexao com bd
    private final PersonRepository personRepository;


    private final PersonMapper personMapper;

    // metodos rest

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        MessageResponseDTO messageResponseDTO = createMessage("Create Person with id: ", savedPerson.getId());

        return messageResponseDTO;
    }

    public List<PersonDTO> getAllPerson() {
        List<Person> allPersons = personRepository.findAll();
        return allPersons.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        Person personFound = personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));
        return personMapper.toDTO(personFound);

    }

    public MessageResponseDTO updatePerson(Long id, PersonDTO personDTO) throws PersonNotFoundException{
        personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));

        Person update = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save((update));

        MessageResponseDTO messageResponseDTO = createMessage("Update person with ID ", savedPerson.getId());

        return messageResponseDTO;
    }

    public void delete(Long id) throws PersonNotFoundException{
        personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }

    private MessageResponseDTO createMessage(String s, Long id2){
        return MessageResponseDTO
                .builder()
                .message(s + id2)
                .build();
    }

}
