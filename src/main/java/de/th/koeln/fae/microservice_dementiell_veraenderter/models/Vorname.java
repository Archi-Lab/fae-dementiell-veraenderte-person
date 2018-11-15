package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.Embeddable;

@Embeddable
public class Vorname {


    private String vorname;

    public Vorname(){

    }

    public Vorname(String vorname){
        //darf keine Numerischen Zeichen enthalten
        String expression = "^[a-zA-Z\\s]+";
        if(vorname.matches(expression)){
            throw new IllegalArgumentException("Ein Vorname darf nur aus Groß- bzw. Kleinbuchstaben bestehen.");
        }
        this.vorname = vorname;
    }
}
