package br.com.gabrielscholzer.backend.repositories;

import br.com.gabrielscholzer.backend.models.Person;
import br.com.gabrielscholzer.backend.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
}
