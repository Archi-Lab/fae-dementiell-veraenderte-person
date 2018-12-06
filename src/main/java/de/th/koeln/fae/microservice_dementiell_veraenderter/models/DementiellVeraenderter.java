package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class DementiellVeraenderter {

    @Embedded
    private Vorname vorname;

    @Embedded
    private Nachname nachname;

    @Embedded
    private Alter alter;

    public DementiellVeraenderter() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private Einwilligung einwilligung;

    @ElementCollection(targetClass = Ereignis.class)
    private List<Ereignis> ereignisprotokoll;

    @Embedded
    private Bild bild;

    public Vorname getVorname() { return vorname; }

    public void setVorname(Vorname vorname) { this.vorname = vorname; }

    public Nachname getNachname() { return nachname; }

    public void setNachname(Nachname nachname) { this.nachname = nachname; }

    public Alter getAlter() { return alter; }

    public void setAlter(Alter alter) { this.alter = alter; }

    public Long getId() {
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
