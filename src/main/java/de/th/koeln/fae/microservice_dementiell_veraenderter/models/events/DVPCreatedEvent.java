package de.th.koeln.fae.microservice_dementiell_veraenderter.models.events;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.DementiellVeraenderter;

import java.time.ZonedDateTime;

public class DVPCreateEvent implements DVPEvent{

    public DVPCreateEvent(DementiellVeraenderter dvp){
        
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public Long getVersion() {
        return null;
    }

    @Override
    public ZonedDateTime getTime() {
        return null;
    }

    @Override
    public byte[] getPayload(ObjectMapper objectMapper) throws JsonProcessingException {
        return new byte[0];
    }

    @Override
    public Class<?> getEntityType() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }
}
