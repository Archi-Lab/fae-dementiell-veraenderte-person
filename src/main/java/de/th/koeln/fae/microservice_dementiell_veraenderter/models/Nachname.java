package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
public class Nachname {

    @Getter
    @Setter
    private String nachname;

    public Nachname(){

    }

    public Nachname(String nachname){
        String expression = "^[a-zA-Z\\s]+";
        if(!nachname.matches(expression)){
            throw new IllegalArgumentException("Ein Nachname darf nur aus Groß- bzw. Kleinbuchstaben bestehen.");
        }
        this.nachname = nachname;
    }
}
