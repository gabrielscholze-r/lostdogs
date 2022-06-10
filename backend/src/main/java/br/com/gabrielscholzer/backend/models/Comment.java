package br.com.gabrielscholzer.backend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private UUID userID;
    @Column(nullable = false)
    private UUID postID;
    @Column(nullable=false)
    private String content;
    @Column(nullable = false)
    private int likes;
    @Column(nullable = false)
    private int dislikes;

    public Comment() {
    }

    public Comment(UUID id, UUID userID, String content, int likes, int dislikes) {
        this.id = id;
        this.userID = userID;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public UUID getId() {
        return id;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}
