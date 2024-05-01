package com.nullhawk.inventory.models;

import jakarta.persistence.Entity;

@Entity
public class Description {
    private String subject;
    private String body;

    public Description(String subject, String body){
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
