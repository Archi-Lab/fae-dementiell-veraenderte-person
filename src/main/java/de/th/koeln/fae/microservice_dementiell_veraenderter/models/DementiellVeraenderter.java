package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.th.koeln.fae.microservice_dementiell_veraenderter.infrastructure.eventing.EventSource;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.th.koeln.fae.microservice_dementiell_veraenderter.infrastructure.eventing.EventPublishingEntityListener;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(EventPublishingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DementiellVeraenderter extends EntityUUID4 implements EventSource {

    public DementiellVeraenderter() {
    }

    @Embedded
    private Vorname vorname;

    @Embedded
    private Nachname nachname;

    @Embedded
    private Alter alter;

    //Nicht Embedded, da Geschlecht ein Enum ist
    private Geschlecht geschlecht;

    @Embedded
    private Einwilligung einwilligung;

    @Embedded
    private Bild bild;

    @Embedded
    private Tracker tracker;

    @Version
    private Long version;

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    // GETTER & SETTER

    public Vorname getVorname() { return vorname; }

    public void setVorname(Vorname vorname) { this.vorname = vorname; }

    public Nachname getNachname() { return nachname; }

    public void setNachname(Nachname nachname) { this.nachname = nachname; }

    public Alter getAlter() { return alter; }

    public void setAlter(Alter alter) { this.alter = alter; }

    public Einwilligung getEinwilligung() { return einwilligung; }

    public void setEinwilligung(Einwilligung einwilligung) { this.einwilligung = einwilligung; }

    public Bild getBild() { return bild; }

    public void setBild(Bild bild) { this.bild = bild; }

    public Geschlecht getGeschlecht() { return geschlecht; }

    public void setGeschlecht(Geschlecht geschlecht) { this.geschlecht = geschlecht; }

    public void setVersion(Long version){
        this.version=version;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public String getAggregateName() { return "dvp";}

    @Override
    public String toString() {
        return "DementiellVeraenderter{" +
        "vorname='" + vorname + '\'' +
        '}';
    }
}
