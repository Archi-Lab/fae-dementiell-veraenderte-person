package de.th.koeln.fae.microservice_dementiell_veraenderter.infrastructure.eventing;

import java.util.UUID;

public interface EventSource {
    
    String getId();
    Long getVersion();
    String getAggregateName();

}
