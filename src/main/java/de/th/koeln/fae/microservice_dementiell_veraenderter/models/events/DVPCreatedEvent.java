package de.th.koeln.fae.microservice_dementiell_veraenderter.models.events;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.DementiellVeraenderter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class DVPCreatedEvent implements DVPEvent{

    final UUID id;
    final DementiellVeraenderter dvp;
    final Instant instant;

    public DVPCreatedEvent(DementiellVeraenderter dvp){
        this.id = UUID.randomUUID();
        this.dvp = dvp;
        this.instant = Instant.now();
    }

    @Override
    public String getId() {
        return id.toString();
    }

    @Override
    public String getKey() {
        return dvp.getId().toString();
    }

    @Override
    public Long getVersion() {
        return 0L;
    }

    @Override
    public ZonedDateTime getTime() {
        return instant.atZone(ZoneId.systemDefault());
    }

    @Override
    public byte[] getPayload(ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(dvp);
    }

    @Override
    public Class<?> getEntityType() {
        return dvp.getClass();
    }

    @Override
    public String getType() {
        return "dvp-created";
    }
}
