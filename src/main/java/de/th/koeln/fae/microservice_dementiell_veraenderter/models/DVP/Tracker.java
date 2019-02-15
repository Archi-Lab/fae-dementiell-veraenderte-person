package de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP;

import javax.persistence.Embeddable;
import java.util.UUID;

/**
 Attribut Tracker der DVP Entität sowie Value-Object im DVP-Aggregate.

Der Tracker-Key muss der Tracker-ID entsprechen, die über die Draußen-Ortung Koordinaten versendet wird.
Erhält die DVP einen neuen Tracker, muss der Tracker entsprechend aktualisiert werden.
 */
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
