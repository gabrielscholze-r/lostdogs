package br.com.gabrielscholzer.backend.services;


import br.com.gabrielscholzer.backend.models.Person;
import br.com.gabrielscholzer.backend.repositories.PersonRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    public static String gerarHash(String senha) throws Exception {
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte hash[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder texto = new StringBuilder();
        for (byte b : hash) {
            texto.append(String.format("%02X", 0xFF & b));
        }
        return texto.toString();
    }

    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person save(Person person) throws Exception {
        person.setPassword(gerarHash(person.getPassword()));
        return personRepository.save(person);
    }
    public List<Person> findAll(){
        return personRepository.findAll();
    }
    public Optional<Person> findByID(UUID id){
        return personRepository.findById(id);
    }

    public boolean existsByEmail(String email){
        return personRepository.existsByEmail(email);
    }
    public Optional<Person> findByEmail(String email){
        return personRepository.findByEmail(email);
    }
    public Object comparePasswords(String testPassword, String password, UUID id) throws Exception {
        if(gerarHash(testPassword).equals(password)){
            return id;
        }
        return "";
    }
    @Transactional
    public void delete(Person person){
        personRepository.delete(person);
    }
}
