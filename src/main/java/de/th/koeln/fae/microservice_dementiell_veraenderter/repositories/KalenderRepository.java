package de.th.koeln.fae.microservice_dementiell_veraenderter.repositories;

import de.th.koeln.fae.microservice_dementiell_veraenderter.models.Kalender;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


public interface KalenderRepository extends CrudRepository<Kalender, Long> {
}
