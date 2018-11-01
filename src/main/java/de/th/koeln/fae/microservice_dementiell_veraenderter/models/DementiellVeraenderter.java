package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class DementiellVeraenderter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection(targetClass = Faehigkeit.class)
    @OneToMany
    private List<Faehigkeit> faehigkeiten;

    @Embedded
    @OneToOne
    @JoinColumn
    private Einwilligung einwilligung;

    @ElementCollection(targetClass = Ereignis.class)
    @OneToMany
    private List<Ereignis> ereignisse;

    @Embedded
    @OneToOne
    @JoinColumn
    private Bild bild;

    @ElementCollection(targetClass = Position.class)
    @OneToMany
    private List<Position> positionsdaten;

    @ElementCollection(targetClass = Kalendereintrag.class)
    @OneToMany
    private List<Kalendereintrag> kalendereintraege;

    public DementiellVeraenderter() {
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

    public List<Ereignis> getEreignisse() {
        return ereignisse;
    }

    public void setEreignisse(List<Ereignis> ereignisse) {
        this.ereignisse = ereignisse;
    }

    public Bild getBild() {
        return bild;
    }

    public void setBild(Bild bild) {
        this.bild = bild;
    }

    public List<Position> getPositionsdaten() {
        return positionsdaten;
    }

    public void setPositionsdaten(List<Position> positionsdaten) {
        this.positionsdaten = positionsdaten;
    }

    public List<Kalendereintrag> getKalendereintraege() {
        return kalendereintraege;
    }

    public void setKalendereintraege(List<Kalendereintrag> kalendereintraege) {
        this.kalendereintraege = kalendereintraege;
    }
}
