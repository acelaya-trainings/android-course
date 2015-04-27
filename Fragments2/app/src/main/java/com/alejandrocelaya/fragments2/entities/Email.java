package com.alejandrocelaya.fragments2.entities;

import java.io.Serializable;

/**
 * Created by cta on 27/04/2015.
 */
public class Email implements Serializable {
    private String name;
    private String subject;
    private String body;

    public Email() {

    }

    public Email(String name, String subject, String body) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
