package br.com.gabrielscholzer.backend.DTOs;

import javax.persistence.Column;
import java.util.UUID;

public class CommentDTO {

    private UUID userID;
    private UUID postID;
    private String content;
    private int likes;
    private int dislikes;

    public CommentDTO() {
    }

    public CommentDTO(UUID userID, String content, int likes, int dislikes) {
        this.userID = userID;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public UUID getUserID() {
        return userID;
    }

    public UUID getPostID() {
        return postID;
    }

    public void setPostID(UUID postID) {
        this.postID = postID;
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
