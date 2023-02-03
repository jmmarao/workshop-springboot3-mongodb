package com.jmmarao.workshopspringboot3mongodb.model.dtos;

import com.jmmarao.workshopspringboot3mongodb.model.entities.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User userEntity) {
        id = userEntity.getId();
        name = userEntity.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
