package de.th.koeln.fae.microservice_dementiell_veraenderter.repositories;

import de.th.koeln.fae.microservice_dementiell_veraenderter.models.DementiellVeraenderter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DVPRepository extends CrudRepository<DementiellVeraenderter, Long> {

    Iterable<DementiellVeraenderter> findAllById(Long id);

}
