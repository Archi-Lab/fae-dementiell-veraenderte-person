package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class DementiellVeraenderter {

    @Embedded
    @Getter
    @Setter
    private Vorname vorname;

    @Embedded
    @Getter
    @Setter
    private Nachname nachname;

    @Embedded
    @Getter
    @Setter
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
