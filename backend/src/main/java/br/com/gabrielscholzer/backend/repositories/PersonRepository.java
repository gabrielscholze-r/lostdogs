package br.com.gabrielscholzer.backend.repositories;

import br.com.gabrielscholzer.backend.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    boolean existsByEmail(String email);

    Optional<Person> findByEmail(String email);
}
