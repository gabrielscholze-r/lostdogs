package br.com.gabrielscholzer.backend.controllers;

import br.com.gabrielscholzer.backend.DTOs.LoginDTO;
import br.com.gabrielscholzer.backend.DTOs.PersonDTO;
import br.com.gabrielscholzer.backend.models.Person;
import br.com.gabrielscholzer.backend.services.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins ="*",maxAge = 3600)
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonDTO personDTO) throws Exception {
        if(personService.existsByEmail(personDTO.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(false);
        }
        var person = new Person();
        BeanUtils.copyProperties(personDTO, person);
        personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getOnePerson(@PathVariable(value="id") UUID id){
//        Optional<Person> PersonOptional = personService.findByID(id);
//        if(!PersonOptional.isPresent()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserNotFound");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(PersonOptional.get());
//    }
    @PostMapping("/auth")
    public ResponseEntity<Object> authenticate(@RequestParam String email, @RequestParam String password) throws Exception {
        Optional<Person> PersonOptional = personService.findByEmail(email);
//        System.out.println(PersonOptional.get().getEmail());
        if(!PersonOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(personService.comparePasswords(password, PersonOptional.get().getPassword(),PersonOptional.get().getId());
//        return personService.comparePasswords(loginForm.getEmail(),loginForm.getPassword());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable(value="id") UUID id){
        Optional<Person> PersonOptional = personService.findByID(id);
        if(!PersonOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserNotFound");
        }
        personService.delete(PersonOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("User Deleted");
    }
    @GetMapping("/{email}")
    public ResponseEntity<Object> getPersonByEmail(@PathVariable(value="email") String email){
        Optional<Person> PersonOptional = personService.findByEmail(email);
        if(!PersonOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserNotFound");
        }
        return ResponseEntity.status(HttpStatus.OK).body(PersonOptional.get());
    }


}
