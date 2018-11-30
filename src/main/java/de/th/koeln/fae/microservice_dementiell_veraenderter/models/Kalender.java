package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kalender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "kalender")
    private DementiellVeraenderter dvp;

    @ElementCollection(targetClass = Kalendereintrag.class)
    private List<Kalendereintrag> kalendereintraege;

    public Kalender() {
    }

    public List<Kalendereintrag> getKalendereintraege() {
        return kalendereintraege;
    }

    public void setKalendereintraege(List<Kalendereintrag> kalendereintraege) {
        this.kalendereintraege = kalendereintraege;
    }
}
