package br.com.gabrielscholzer.backend.services;

import br.com.gabrielscholzer.backend.models.Post;
import br.com.gabrielscholzer.backend.repositories.PostRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post save(Post post) throws Exception{
        LocalDate date = LocalDate.now();
        post.setLocalDate(date);
        return postRepository.save(post);
    }

    public Post update(Post post) throws Exception{
        return postRepository.save(post);
    }
    public List<Post> findAll(){return postRepository.findAll();}

    public Optional<Post> findByID(UUID id){return postRepository.findById(id);}

    @Transactional
    public void delete(Post post){postRepository.delete(post);}
}
