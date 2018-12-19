package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class DementiellVeraenderter {

    private static final Logger log = LoggerFactory.getLogger(DementiellVeraenderter.class);

    @Embedded
    private Vorname vorname;

    @Embedded
    private Nachname nachname;

    @Embedded
    private Alter alter;

    public DementiellVeraenderter() {
    }

    @Id
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private UUID id;

    @Embedded
    private Einwilligung einwilligung;

    @ElementCollection(targetClass = Ereignis.class)
    private List<Ereignis> ereignisprotokoll;

    @Embedded
    private Bild bild;

    @Embedded
    private Tracker tracker;

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public Vorname getVorname() { return vorname; }

    public void setVorname(Vorname vorname) { this.vorname = vorname; }

    public Nachname getNachname() { return nachname; }

    public void setNachname(Nachname nachname) { this.nachname = nachname; }

    public Alter getAlter() { return alter; }

    public void setAlter(Alter alter) { this.alter = alter; }

    public UUID getId() {
        return id;
    }

    public Einwilligung getEinwilligung() {
        return einwilligung;
    }

    public void setEinwilligung(Einwilligung einwilligung) {
        this.einwilligung = einwilligung;
    }

    public List<Ereignis> getEreignisprotokoll() {
        return ereignisprotokoll;
    }

    public void setEreignisprotokoll(List<Ereignis> ereignisprotokoll) {
        this.ereignisprotokoll = ereignisprotokoll;
    }

    public Bild getBild() {
        return bild;
    }

    public void setBild(Bild bild) {
        this.bild = bild;
    }

    @Override
    public String toString() {
        return "DementiellVeraenderter{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", alter=" + alter +
                '}';
    }
}
