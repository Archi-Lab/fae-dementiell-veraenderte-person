package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class DementiellVeraenderter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection(targetClass = Faehigkeit.class)
    private List<Faehigkeit> faehigkeiten;

    @Embedded
    private Einwilligung einwilligung;

    @ElementCollection(targetClass = Ereignis.class)
    private List<Ereignis> ereignisse;

    @Embedded
    @OneToOne
    @JoinColumn
    private Bild bild;

    @ElementCollection(targetClass = Position.class)
    private List<Position> positionsdaten;

    @ElementCollection(targetClass = Kalendereintrag.class)
    private List<Kalendereintrag> kalendereintraege;
}
