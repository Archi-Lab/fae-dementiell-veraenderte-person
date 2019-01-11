package de.th.koeln.fae.microservice_dementiell_veraenderter.controller;

import de.th.koeln.fae.microservice_dementiell_veraenderter.models.DementiellVeraenderter;
import de.th.koeln.fae.microservice_dementiell_veraenderter.repositories.DVPRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class DementiellVeraenderterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DementiellVeraenderterController.class);
    private final DVPRepository dvpRepository;

    @Autowired
    public DementiellVeraenderterController(DVPRepository dvpRepository){
        this.dvpRepository = dvpRepository;
    }

    @Bean
    public ResourceProcessor<Resources<DementiellVeraenderter>> personProcessor() {

        return new ResourceProcessor<Resources<DementiellVeraenderter>>() {

            @Override
            public Resources<DementiellVeraenderter> process(Resources<DementiellVeraenderter> resource) {
                resource.add(new Link(resource.getLink(Link.REL_SELF).getHref() + "dvps/{dvpid}", "dvp"));

                return resource;
            }
        };
    }

    @GetMapping(path = "/dvps")
    public ResponseEntity<?> getDVPs(){
        final Iterable<DementiellVeraenderter> personList = this.dvpRepository.findAll();

        Resources<DementiellVeraenderter> resources = new Resources<>(personList);

        resources.add(linkTo(methodOn(DementiellVeraenderterController.class).getDVPs()).withSelfRel());
        //resources.add(linkTo(methodOn(DementiellVeraenderterController.class).postDVP(null)).withRel("create"));

        //foreach --> person in personlist {resources.add(..(withRel("dvp"+person.getid));}

        for (final DementiellVeraenderter dvp:personList
        ) {
            String dvpId = dvp.getId();
            resources.add(linkTo(methodOn(DementiellVeraenderterController.class).getDVPs()).slash(dvpId).withRel(dvpId));
        }
        return  ResponseEntity.ok(resources);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                              POST MAPPINGS                                                                     //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping(path = "/dvps")
    public ResponseEntity<DementiellVeraenderter> postDVP(@RequestBody DementiellVeraenderter newDVP){
        LOGGER.info("CREATED NEW PERSON!");
        return new ResponseEntity<>(dvpRepository.save(newDVP), HttpStatus.CREATED);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                              PUT MAPPINGS                                                                     //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



}
