package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.Embeddable;

@Embeddable
public class Nachname {

    private String nachname;

    public Nachname(){

    }

    public Nachname(String nachname){
        String expression = "^[a-zA-Z\\s]+";
        if(nachname.matches(expression)){
            throw new IllegalArgumentException("Ein Nachname darf nur aus Groß- bzw. Kleinbuchstaben bestehen.");
        }
        this.nachname = nachname;
    }
}
