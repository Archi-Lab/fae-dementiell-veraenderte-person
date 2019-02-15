package de.th.koeln.fae.microservice_dementiell_veraenderter;

import de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP.*;
import de.th.koeln.fae.microservice_dementiell_veraenderter.repositories.DVPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 Wird verwendet, um Beispieldaten zu erzeugen und in der Datenbank zu speichern.
 */

@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DVPRepository dvpRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        //erstellt und speichert dvp1
        final DementiellVeraenderter dvp1 = new DementiellVeraenderter();

        dvp1.setNachname(new Nachname("Mustermann"));
        dvp1.setVorname(new Vorname("Max"));
        dvp1.setAlter(new Alter(89));
        dvp1.setGeschlecht(Geschlecht.M);
        dvp1.setBild(new Bild("Pfad"));
        dvp1.setEinwilligung(new Einwilligung("Ich moechte das nicht!"));
        dvp1.setTracker(new Tracker(UUID.fromString("c11430ed-5aad-3d98-84fb-00fbac3cb9e9")));

        final DementiellVeraenderter savedDvp = this.dvpRepository.save(dvp1);

        //erstellt und speichert dvp2
        final DementiellVeraenderter dvp2 = new DementiellVeraenderter();

        dvp2.setNachname(new Nachname("Toni"));
        dvp2.setVorname(new Vorname("Taco"));
        dvp2.setAlter(new Alter(177));
        dvp2.setGeschlecht(Geschlecht.M);
        dvp2.setBild(new Bild("Pfad"));
        dvp2.setEinwilligung(new Einwilligung("Ayayay Arriba"));
        dvp2.setTracker(new Tracker(UUID.fromString("0cd7addf-c9d4-3b5f-8a28-bbe2f0e761a0")));

        this.dvpRepository.save(dvp2);

        //erstellt und speichert dvp3
        final DementiellVeraenderter dvp3 = new DementiellVeraenderter();

        dvp3.setNachname(new Nachname("Kolumna"));
        dvp3.setVorname(new Vorname("Karla"));
        dvp3.setAlter(new Alter(65));
        dvp3.setGeschlecht(Geschlecht.F);
        dvp3.setBild(new Bild("Pfad"));
        dvp3.setEinwilligung(new Einwilligung("Brauchte ich nie!"));
        dvp3.setTracker(new Tracker(UUID.fromString("1df2d81d-c7d0-3981-9049-45af8f76fb6a")));

        this.dvpRepository.save(dvp3);
    }
}