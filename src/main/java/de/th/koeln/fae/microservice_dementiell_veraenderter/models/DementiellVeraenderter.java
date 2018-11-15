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

    @ElementCollection(targetClass = Faehigkeit.class)
    private List<Faehigkeit> faehigkeiten;

/*    @ElementCollection(targetClass = Faehigkeit.class)
    private List<Faehigkeit> nicht_faehigkeiten;*/

    @Embedded
    private Einwilligung einwilligung;

    @ElementCollection(targetClass = Ereignis.class)
    private List<Ereignis> ereignisprotokoll;

    @Embedded
    private Bild bild;

    @ElementCollection(targetClass = Position.class)
    private List<Position> bewegungsprofil;

    @ElementCollection(targetClass = Kalendereintrag.class)
    private List<Kalendereintrag> kalendereintraege;

    public Vorname getVorname() {
        return vorname;
    }

    public void setVorname(Vorname vorname) {
        this.vorname = vorname;
    }

    public Nachname getNachname() {
        return nachname;
    }

    public void setNachname(Nachname nachname) {
        this.nachname = nachname;
    }

    public Alter getAlter() {
        return alter;
    }

    public void setAlter(Alter alter) {
        this.alter = alter;
    }

    public Long getId() {
        return id;
    }

    public List<Faehigkeit> getFaehigkeiten() {
        return faehigkeiten;
    }

    public void setFaehigkeiten(List<Faehigkeit> faehigkeiten) {
        this.faehigkeiten = faehigkeiten;
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

    public List<Position> getBewegungsprofil() {
        return bewegungsprofil;
    }

    public void setBewegungsprofil(List<Position> bewegungsprofil) {
        this.bewegungsprofil = bewegungsprofil;
    }

    public List<Kalendereintrag> getKalendereintraege() {
        return kalendereintraege;
    }

    public void setKalendereintraege(List<Kalendereintrag> kalendereintraege) {
        this.kalendereintraege = kalendereintraege;
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
