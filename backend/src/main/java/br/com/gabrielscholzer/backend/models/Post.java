package br.com.gabrielscholzer.backend.models;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="tb_post")
public class Post implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, name = "userUID")
    private UUID userID;
    @Column(nullable = false, name = "content")
    private String content;
    @Column(nullable = false, name = "date")
    private LocalDate localDate;


//    @Lob
//    @Column(nullable = false, name = "image")
//    private MultipartFile image;
//    @Column(nullable = false, name = "comments")
//    private List<Comment> commentList;

    public UUID getId() {
        return id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
