package br.com.gabrielscholzer.backend.controllers;

import br.com.gabrielscholzer.backend.DTOs.CommentDTO;
import br.com.gabrielscholzer.backend.models.Comment;
import br.com.gabrielscholzer.backend.models.Person;
import br.com.gabrielscholzer.backend.services.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins ="*",maxAge = 3600)
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<Object> savePerson(@RequestBody @Valid CommentDTO commentDTO) throws Exception {
        var comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        commentService.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

//    @GetMapping("/post")
//    public ResponseEntity<List<Person>> getAllComments(){
//
//        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
//    }


}
