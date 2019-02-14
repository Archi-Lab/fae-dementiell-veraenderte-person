package de.th.koeln.fae.microservice_dementiell_veraenderter.repositories;

import de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP.DementiellVeraenderter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource (path = "dvps")
public interface DVPRepository extends CrudRepository<DementiellVeraenderter, UUID> {
}
