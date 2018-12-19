package de.th.koeln.fae.microservice_dementiell_veraenderter.models.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.ZonedDateTime;

public interface DVPEvent {

    String getId();

    String getKey();

    Long getVersion();

    ZonedDateTime getTime();

    byte[] getPayload(ObjectMapper objectMapper) throws JsonProcessingException;

    Class<?> getEntityType();

    String getType();

}
