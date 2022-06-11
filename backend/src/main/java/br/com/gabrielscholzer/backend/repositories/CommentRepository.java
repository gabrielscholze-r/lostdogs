package br.com.gabrielscholzer.backend.repositories;

import br.com.gabrielscholzer.backend.models.Comment;
import br.com.gabrielscholzer.backend.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findAllById(UUID id);
}
