package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.*;

@Embeddable
public class Bild {

    private String pfad;

    public Bild(){

    }

    public Bild(String pfad) {
        this.pfad = pfad;
    }

    public String getPfad() {
        return pfad;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }
}
