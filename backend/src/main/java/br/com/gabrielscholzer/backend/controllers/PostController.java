package br.com.gabrielscholzer.backend.controllers;

import br.com.gabrielscholzer.backend.DTOs.CommentDTO;
import br.com.gabrielscholzer.backend.DTOs.PostDTO;
import br.com.gabrielscholzer.backend.models.Comment;
import br.com.gabrielscholzer.backend.models.Post;
import br.com.gabrielscholzer.backend.services.PostService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
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
        LocalDate l = LocalDate.now();
        post.setLocalDate(l);
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PostNotFound");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Post deleted");
    }
    @PostMapping("/update")
    public ResponseEntity<Object> updatePost(@RequestBody @Valid PostDTO postDTO) throws Exception{
        var post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        postService.update(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
//    @GetMapping("/commentList/{id}")
//    public ResponseEntity<Object> CommentList(@PathVariable(value="id") UUID postID) throws Exception{
//        Optional<Post> postOptional = postService.findByID(postID);
//        if(!postOptional.isPresent()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PostNotFound");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(postOptional.get().getCommentList());
//    }

//    @PostMapping("/addComment")
//    public ResponseEntity<Object> addComment(@RequestBody CommentDTO commentDTO, @RequestParam("PostID") UUID postID) throws Exception {
//        Optional<Post> postOptional = postService.findByID(postID);
//        if(!postOptional.isPresent()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PostNotFound");
//        }
//        List<Comment> commentList = postOptional.get().getCommentList();
//        var comment = new Comment();
//        BeanUtils.copyProperties(commentDTO, comment);
//        commentList.add(comment);
//        postOptional.get().setCommentList(commentList);
//        return ResponseEntity.status(HttpStatus.OK).body(postService.save(postOptional.get()));
//    }

}
