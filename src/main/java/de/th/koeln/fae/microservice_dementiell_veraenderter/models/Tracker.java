package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class Tracker {

    public UUID id;

    public Tracker() {
    }

    public Tracker(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
