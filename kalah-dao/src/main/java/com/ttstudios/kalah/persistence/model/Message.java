package com.ttstudios.kalah.persistence.model;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = -4722029482810841995L;

    private String message;
    private int id;

    public Message() {

    }

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}