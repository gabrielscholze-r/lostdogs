package br.com.gabrielscholzer.backend.models;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="tb_post")
public class Post implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private UUID userID;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private LocalDate localDate;
    @Column(nullable = false)
    @Lob
    private byte[] image;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
