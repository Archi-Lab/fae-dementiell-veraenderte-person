package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.Embeddable;
import java.sql.Timestamp;

@Embeddable
public class Ereignis {

    private Timestamp timestamp;
    private String beschreibung;

    public  Ereignis(){

    }

    public Ereignis(Timestamp timestamp, String beschreibung) {
        this.timestamp = timestamp;
        this.beschreibung = beschreibung;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
