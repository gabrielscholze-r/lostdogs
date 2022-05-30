package br.com.gabrielscholzer.backend.DTOs;

import javax.validation.constraints.NotBlank;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PersonDTO {
    @NotBlank
    private String userName;
    @NotBlank
    private String phone;
    @NotBlank
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.password = password;
    }
}
