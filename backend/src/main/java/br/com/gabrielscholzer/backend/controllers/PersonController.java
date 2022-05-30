package br.com.gabrielscholzer.backend.controllers;

import br.com.gabrielscholzer.backend.DTOs.PersonDTO;
import br.com.gabrielscholzer.backend.models.Person;
import br.com.gabrielscholzer.backend.services.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins ="*",maxAge = 3600)
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonDTO personDTO){
        var person = new Person();
        BeanUtils.copyProperties(personDTO, person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));

    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
    }


}
