package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.List;

@Embeddable
public class Kalender {

    @ElementCollection
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
