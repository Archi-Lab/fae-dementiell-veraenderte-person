package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.Embeddable;
import java.sql.Date;
import java.sql.Time;

@Embeddable
public class Ereignis {

    private Time time;
    private Date date;
    private String beschreibung;

    public Ereignis(Time time, Date date, String beschreibung) {
        this.time = time;
        this.date = date;
        this.beschreibung = beschreibung;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
