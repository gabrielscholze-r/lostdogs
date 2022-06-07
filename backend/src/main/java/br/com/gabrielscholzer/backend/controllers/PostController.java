package br.com.gabrielscholzer.backend.controllers;

import br.com.gabrielscholzer.backend.DTOs.PostDTO;
import br.com.gabrielscholzer.backend.models.Post;
import br.com.gabrielscholzer.backend.services.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<Object> savePost(@RequestBody @Valid PostDTO postDTO) throws Exception{
        var post = new Post();
        BeanUtils.copyProperties(postDTO,post);
        postService.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(postService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable(value="id") UUID id){
        Optional<Post> postOptional = postService.findByID(id);
        if(!postOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserNotFound");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Post deleted");

    }
}
