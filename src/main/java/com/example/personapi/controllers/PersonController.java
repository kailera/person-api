package com.example.personapi.controllers;

import com.example.personapi.DTO.MessageResponseDTO;
import com.example.personapi.DTO.requests.PersonDTO;
import com.example.personapi.entities.Person;
import com.example.personapi.exception.PersonNotFoundException;
import com.example.personapi.repositories.PersonRepository;
import com.example.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create (@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }


    @GetMapping
    @ResponseStatus
    public  List<PersonDTO> getAllPersons(){

        return personService.getAllPerson();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findByID(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updatePerson(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException{
        return personService.updatePerson(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id) throws PersonNotFoundException{
        personService.delete(id);
    }
}
