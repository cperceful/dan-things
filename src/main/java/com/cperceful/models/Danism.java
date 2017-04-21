package com.cperceful.models;

import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * class for storing Danisms in database
 */
@Entity
public class Danism {

    @GeneratedValue
    @Id
    private int id;

    @NotNull
    @Size(min = 3)
    private String title;

    @NotNull
    @Size(min = 3)
    private String body;

    public Danism(){

    }

    public Danism(String title, String body){
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
