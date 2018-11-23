package de.th.koeln.fae.microservice_dementiell_veraenderter.controller;

import de.th.koeln.fae.microservice_dementiell_veraenderter.models.DementiellVeraenderter;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.Kalendereintrag;
import de.th.koeln.fae.microservice_dementiell_veraenderter.repositories.DVPRepository;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
                    //resource.add(new Link(resource.getLink(Link.REL_SELF).getHref() + "/appoints",
                    //        "kalender"));
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

        //resources.add(linkTo(methodOn(DementiellVeraenderterController.class).getKalender()).withSelfRel());

        LOGGER.info("RETURN ALL PERSONS!");
        return  ResponseEntity.ok(resources);

    }

    @GetMapping(path = "/dvps/{dvpid}/appoints")
    private ResponseEntity<List<Kalendereintrag>> getKalender(@PathVariable("dvpid") long dvpId) {
        final DementiellVeraenderter dvp;
        if(this.dvpRepository.findById(dvpId).isPresent())
             dvp = this.dvpRepository.findById(dvpId).get();
        else
            return ResponseEntity.status(404).build();



       // resources.add(linkTo(methodOn(DementiellVeraenderterController.class).getKalender(dvpId)).withSelfRel());

        return new ResponseEntity<>(dvp.getKalendereintraege(), HttpStatus.OK);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                              POST MAPPINGS                                                                     //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping(path = "/dvps")
    public ResponseEntity<DementiellVeraenderter> postDVP(@RequestBody DementiellVeraenderter newDVP){

        LOGGER.info("CREATED NEW PERSON!");
        return new ResponseEntity<>(dvpRepository.save(newDVP), HttpStatus.CREATED);
    }

    @PostMapping(path = "/dvps/{dvpid}/appoints")
    public ResponseEntity<List<Kalendereintrag>> postKalendereintrag(@PathVariable("dvpid") long dvpId, @RequestBody Kalendereintrag newKalendereintrag){

        final DementiellVeraenderter dvp;
        if(this.dvpRepository.findById(dvpId).isPresent()) {
            LOGGER.info("DVP GEFUNDEN!");
            dvp = this.dvpRepository.findById(dvpId).get();
        }
        else
            return null;
        List<Kalendereintrag> kalendereintraege = dvp.getKalendereintraege();
        kalendereintraege.add(newKalendereintrag);
        dvp.setKalendereintraege(kalendereintraege);
        dvpRepository.save(dvp);

        LOGGER.info("CREATED NEW KALENDEREINTRAG!");
        return new ResponseEntity<>(dvp.getKalendereintraege(), HttpStatus.CREATED);
    }
}
