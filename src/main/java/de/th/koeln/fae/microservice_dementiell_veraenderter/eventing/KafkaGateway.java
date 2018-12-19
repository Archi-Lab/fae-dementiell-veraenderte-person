package de.th.koeln.fae.microservice_dementiell_veraenderter.eventing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.events.DVPEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaGateway.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final String topic;

    @Autowired
    public KafkaGateway(final KafkaTemplate<String, String> kafkaTemplate, final ObjectMapper objectMapper, @Value("${eventing.topic}") final String topic){
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.topic = topic;
    }

    public ListenableFuture<SendResult<String, String>> publishDVPEvent(DVPEvent dvpEvent) {
        LOGGER.info("publishing event {} to topic {}", dvpEvent.getId(), topic);
        return kafkaTemplate.send(topic, dvpEvent.getKey(), toDVPEventMessage(dvpEvent));
    }

    private String toDVPEventMessage(DVPEvent dvpEvent) {
        try {
            final Map<String, Object> message = new HashMap<>();
            message.put("id", dvpEvent.getId());
            message.put("key", dvpEvent.getKey());
            message.put("time", dvpEvent.getTime());
            message.put("type", dvpEvent.getType());
            message.put("version", dvpEvent.getVersion());
            message.put("payload", objectMapper.readValue(dvpEvent.getPayload(objectMapper), dvpEvent.getEntityType()));
            return objectMapper.writeValueAsString(message);
        } catch (final JsonProcessingException e) {
            LOGGER.error("Could not serialize event with id {}", dvpEvent.getId(), e);
            // FIXME error handling?
            return "";
        } catch (IOException e) {
            LOGGER.error("Could not read payload for event with id {}", dvpEvent.getId(), e);
            return "";
        }
    }
}
