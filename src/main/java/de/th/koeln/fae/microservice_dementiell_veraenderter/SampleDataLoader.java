package de.th.koeln.fae.microservice_dementiell_veraenderter;

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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DVPRepository dvpRepository;

    private final KafkaGateway eventPublisher;
    private static final Logger log = LoggerFactory.getLogger(SampleDataLoader.class);
    @Autowired
    SampleDataLoader(final KafkaGateway eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        final DementiellVeraenderter dvp = new DementiellVeraenderter();

        List<Ereignis> ereignisList = new ArrayList<Ereignis>();
        ereignisList.add(new Ereignis(new Timestamp(System.currentTimeMillis()), "Beschreibung"));

        dvp.setNachname(new Nachname("Mustermann"));
        dvp.setVorname(new Vorname("Max"));
        dvp.setAlter(new Alter(89));
        dvp.setBild(new Bild("Pfad"));
        dvp.setEinwilligung(new Einwilligung("Ich moechte das nicht!"));
        dvp.setEreignisprotokoll(ereignisList);

        final DementiellVeraenderter savedDvp = this.dvpRepository.save(dvp);

        DVPEvent dvpEvent = new DVPCreatedEvent(dvp);
        try {
            SendResult<String, String> sendResult = eventPublisher.publishDVPEvent(dvpEvent)
                    .get(1, TimeUnit.SECONDS);

            log.info(sendResult.toString());
        } catch (final Exception ex) {
            log.info("An " + ex.getClass() + "occured!");
        }
    }
}