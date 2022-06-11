package br.com.gabrielscholzer.backend.services;

import br.com.gabrielscholzer.backend.models.Comment;
import br.com.gabrielscholzer.backend.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;


    @Transactional
    public Comment save(Comment comment) throws Exception {
        return commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findAllById(UUID id) { return commentRepository.findAllById(id);}
}
