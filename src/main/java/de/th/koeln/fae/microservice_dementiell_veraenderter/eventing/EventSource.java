package de.th.koeln.fae.microservice_dementiell_veraenderter.eventing;

import de.th.koeln.fae.microservice_dementiell_veraenderter.models.DementiellVeraenderter;

public interface EventSource {

    Long getId();
    Long getVersion();
    DementiellVeraenderter getDVP();

}
