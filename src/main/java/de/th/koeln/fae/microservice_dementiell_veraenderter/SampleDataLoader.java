package de.th.koeln.fae.microservice_dementiell_veraenderter;

import de.th.koeln.fae.microservice_dementiell_veraenderter.models.*;
import de.th.koeln.fae.microservice_dementiell_veraenderter.repositories.DVPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DVPRepository dvpRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        final DementiellVeraenderter dvp = new DementiellVeraenderter();

        List<Ereignis> ereignisList = new ArrayList<Ereignis>();
        ereignisList.add(new Ereignis(new Timestamp(System.currentTimeMillis()), "Beschreibung"));

        List<Faehigkeit> faehigkeitList = new ArrayList<Faehigkeit>();
        faehigkeitList.add(new Faehigkeit("Bus fahren", "Nur noch mit Helm."));

        List<Kalendereintrag> kalendereintragList = new ArrayList<Kalendereintrag>();

        Kalender kalender = new Kalender();

        kalendereintragList.add(new Kalendereintrag("Zahnarzt", "Zähne ansehen", new Timestamp(System.currentTimeMillis())));

        kalender.setKalendereintraege(kalendereintragList);

        List<Position> positionList = new ArrayList<Position>();
        positionList.add(new Position(938383, 393939, new Timestamp(System.currentTimeMillis())));

        dvp.setNachname(new Nachname("Mustermann"));
        dvp.setVorname(new Vorname("Max"));
        dvp.setAlter(new Alter(89));
        dvp.setBild(new Bild("Pfad"));
        dvp.setEinwilligung(new Einwilligung("Ich moechte das nicht!"));
        dvp.setEreignisprotokoll(ereignisList);
        dvp.setFaehigkeiten(faehigkeitList);
        dvp.setKalender(kalender);
        dvp.setBewegungsprofil(positionList);

        final DementiellVeraenderter savedDvp = this.dvpRepository.save(dvp);


    }
}
