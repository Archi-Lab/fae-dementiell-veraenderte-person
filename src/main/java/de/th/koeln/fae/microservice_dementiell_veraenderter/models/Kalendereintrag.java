package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.Embeddable;
import java.sql.Timestamp;

@Embeddable
public class Kalendereintrag {

    private String title;
    private String description;
    private Timestamp timestamp;

    public Kalendereintrag(String title, String description, Timestamp timestamp) {
        this.title = title;
        this.description = description;
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
