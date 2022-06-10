package br.com.gabrielscholzer.backend.DTOs;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.util.UUID;

public class PostDTO {
    private String content;
    private byte[] image;
    //coments list

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
