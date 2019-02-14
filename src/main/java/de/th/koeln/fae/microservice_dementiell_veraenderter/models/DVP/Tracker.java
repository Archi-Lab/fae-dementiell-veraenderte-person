package de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP;

import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class Tracker {

    public UUID key;

    public Tracker() {
    }

    public Tracker(UUID key) {
        this.key = key;
    }

    public UUID getKey() {
        return key;
    }

    public void setKey(UUID key) {
        this.key = key;
    }
}
