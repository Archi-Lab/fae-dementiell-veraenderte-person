package de.th.koeln.fae.microservice_dementiell_veraenderter;

import de.th.koeln.fae.microservice_dementiell_veraenderter.eventing.EventSource;
import de.th.koeln.fae.microservice_dementiell_veraenderter.eventing.KafkaGateway;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.*;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.events.DVPCreatedEvent;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.events.DVPEvent;
import de.th.koeln.fae.microservice_dementiell_veraenderter.repositories.DVPRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DVPRepository dvpRepository;

//    private final KafkaGateway eventPublisher;
//    private static final Logger log = LoggerFactory.getLogger(SampleDataLoader.class);
//    @Autowired
//    SampleDataLoader(final KafkaGateway eventPublisher){
//        this.eventPublisher = eventPublisher;
//    }rivate final KafkaGateway eventPublisher;
//    private static final Logger log = LoggerFactory.getLogger(SampleDataLoader.class);
//    @Autowired
//    SampleDataLoader(final KafkaGateway eventPublisher){
//        this.eventPublisher = eventPublisher;
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        final DementiellVeraenderter dvp1 = new DementiellVeraenderter();

        List<Ereignis> ereignisList = new ArrayList<Ereignis>();
        ereignisList.add(new Ereignis(new Timestamp(System.currentTimeMillis()), "Beschreibung"));

        dvp1.setNachname(new Nachname("Mustermann"));
        dvp1.setVorname(new Vorname("Max"));
        dvp1.setAlter(new Alter(89));
        dvp1.setBild(new Bild("Pfad"));
        dvp1.setEinwilligung(new Einwilligung("Ich moechte das nicht!"));
        dvp1.setEreignisprotokoll(ereignisList);
        dvp1.setTracker(new Tracker(UUID.fromString("c11430ed-5aad-3d98-84fb-00fbac3cb9e9")));

        final DementiellVeraenderter savedDvp = this.dvpRepository.save(dvp1);

//        DVPEvent dvpEvent = new DVPCreatedEvent(dvp1);
//        try {
//            SendResult<String, String> sendResult = eventPublisher.publishDVPEvent(dvpEvent)
//                    .get(1, TimeUnit.SECONDS);
//
//            log.info(sendResult.toString());
//        } catch (final Exception ex) {
//            log.info("An " + ex.getClass() + "occured!");
//        }

        /////////////////////////////////////////////


        final DementiellVeraenderter dvp3 = new DementiellVeraenderter();

        List<Ereignis> ereignisList3 = new ArrayList<Ereignis>();
        ereignisList3.add(new Ereignis(new Timestamp(System.currentTimeMillis()), "Im Zoo"));

        dvp3.setNachname(new Nachname("Kolumna"));
        dvp3.setVorname(new Vorname("Karla"));
        dvp3.setAlter(new Alter(65));
        dvp3.setBild(new Bild("Pfad"));
        dvp3.setEinwilligung(new Einwilligung("Brauchte ich nie!"));
        dvp3.setEreignisprotokoll(ereignisList);
        dvp3.setTracker(new Tracker(UUID.fromString("1df2d81d-c7d0-3981-9049-45af8f76fb6a")));

        this.dvpRepository.save(dvp3);

//        dvpEvent = new DVPCreatedEvent(dvp3);
//        try {
//            SendResult<String, String> sendResult = eventPublisher.publishDVPEvent(dvpEvent)
//                    .get(1, TimeUnit.SECONDS);
//
//            log.info(sendResult.toString());
//        } catch (final Exception ex) {
//            log.info("An " + ex.getClass() + "occured!");
//        }

        /////////////////////////////////////////////////


        final DementiellVeraenderter dvp2 = new DementiellVeraenderter();

        List<Ereignis> ereignisList2 = new ArrayList<Ereignis>();
        ereignisList2.add(new Ereignis(new Timestamp(System.currentTimeMillis()), "Schießerei am Taco Stand"));

        dvp2.setNachname(new Nachname("Toni"));
        dvp2.setVorname(new Vorname("Taco"));
        dvp2.setAlter(new Alter(177));
        dvp2.setBild(new Bild("Pfad"));
        dvp2.setEinwilligung(new Einwilligung("Ayayay Arriba"));
        dvp2.setEreignisprotokoll(ereignisList);
        dvp2.setTracker(new Tracker(UUID.fromString("0cd7addf-c9d4-3b5f-8a28-bbe2f0e761a0")));

        this.dvpRepository.save(dvp2);

//        dvpEvent = new DVPCreatedEvent(dvp2);
//        try {
//            SendResult<String, String> sendResult = eventPublisher.publishDVPEvent(dvpEvent)
//                    .get(1, TimeUnit.SECONDS);
//
//            log.info(sendResult.toString());
//        } catch (final Exception ex) {
//            log.info("An " + ex.getClass() + "occured!");
//        }
    }
}