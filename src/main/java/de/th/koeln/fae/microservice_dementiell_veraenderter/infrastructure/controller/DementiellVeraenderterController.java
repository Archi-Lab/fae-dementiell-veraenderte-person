package de.th.koeln.fae.microservice_dementiell_veraenderter.infrastructure.controller;

import de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP.DementiellVeraenderter;
import de.th.koeln.fae.microservice_dementiell_veraenderter.repositories.DVPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class DementiellVeraenderterController {

    private final DVPRepository dvpRepository;

    @Autowired
    public DementiellVeraenderterController(DVPRepository dvpRepository){
        this.dvpRepository = dvpRepository;
    }

    /**
     * Diese Methode  soll die "normale" get all methode dadurch ergänzen, dass ein Link zu jeder DVP mit zurückgegeben wird.
     *
     * @return Alle DVP Objekte und Links ind der Form dvpid: linkto(dvp)
     */
    @GetMapping(path = "/dvps")
    public ResponseEntity<?> getDVPs(){
        final Iterable<DementiellVeraenderter> personList = this.dvpRepository.findAll();

        Resources<DementiellVeraenderter> resources = new Resources<>(personList);

        resources.add(linkTo(methodOn(DementiellVeraenderterController.class).getDVPs()).withSelfRel());

        for (final DementiellVeraenderter dvp:personList
        ) {
            String dvpId = dvp.getId().toString();
            resources.add(linkTo(methodOn(DementiellVeraenderterController.class).getDVPs()).slash(dvpId).withRel(dvpId));
        }
        return  ResponseEntity.ok(resources);

    }
}
