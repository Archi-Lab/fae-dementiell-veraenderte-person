package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
public class Vorname {

    @Getter
    @Setter
    private String vorname;

    public Vorname(){

    }

    public Vorname(String vorname){
        //darf keine Numerischen Zeichen enthalten
        String expression = "^[a-zA-Z\\s]+";
        if(!vorname.matches(expression)){
            throw new IllegalArgumentException("Ein Vorname darf nur aus Groß- bzw. Kleinbuchstaben bestehen.");
        }
        this.vorname = vorname;
    }

    @Override
    public String toString() {
        return "Vorname{" +
                "vorname='" + vorname + '\'' +
                '}';
    }
}
