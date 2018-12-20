package de.th.koeln.fae.microservice_dementiell_veraenderter.eventing;

import de.th.koeln.fae.microservice_dementiell_veraenderter.SampleDataLoader;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.DementiellVeraenderter;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.events.DVPCreatedEvent;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.events.DVPEvent;
import de.th.koeln.fae.microservice_dementiell_veraenderter.repositories.DVPRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class EventPublishingEntityListener {

    private final KafkaGateway eventPublisher;
//    private static final Logger log = LoggerFactory.getLogger(SampleDataLoader.class);
    @Autowired
    EventPublishingEntityListener(final KafkaGateway eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    @PrePersist
    void onPersist(DementiellVeraenderter entity) { fireEvent(new DVPCreatedEvent(entity)); }

//    @PreUpdate
//    public void onUpdate(EventSource entity) {
//        publishEvent(entity, "updated");
//    }
//
//    @PreRemove
//    public void onRemove(EventSource entity) {
//        publishEvent(entity, "deleted");
//    }

    public void fireEvent(DVPEvent event){
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                eventPublisher.publishDVPEvent(event);
            }
        });
    }
}
