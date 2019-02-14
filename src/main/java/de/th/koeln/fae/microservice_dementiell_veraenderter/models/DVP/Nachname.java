package de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP;

import javax.persistence.Embeddable;

/*
Value-Object im DVP-Aggregate (DVP <- Nachname)
 */
@Embeddable
public class Nachname {

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

    @Override
    public String toString() {
        return "Nachname{" +
                "nachname='" + nachname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object other){
        return other.getClass() == this.getClass() && ((Nachname) other).nachname.equals(this.nachname);
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}
