package br.com.gabrielscholzer.backend.services;


import br.com.gabrielscholzer.backend.models.Person;
import br.com.gabrielscholzer.backend.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {
    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person save(Person person){
        return personRepository.save(person);
    }
    public List<Person> findAll(){
        return personRepository.findAll();
    }
}
