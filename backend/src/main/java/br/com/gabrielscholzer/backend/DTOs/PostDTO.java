package br.com.gabrielscholzer.backend.DTOs;

import java.util.UUID;

public class PostDTO {
    private UUID userID;
    private String content;
    private byte[] image;
    //coments list


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
