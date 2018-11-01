package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.Embeddable;
import java.sql.Date;
import java.sql.Time;

@Embeddable
public class Kalendereintrag {

    private Time time;
    private Date date;
    private String title;
    private String description;

    public Kalendereintrag(Time time, Date date, String title, String description) {
        this.time = time;
        this.date = date;
        this.title = title;
        this.description = description;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
