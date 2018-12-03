package de.th.koeln.fae.microservice_dementiell_veraenderter.dvp.models;

import de.th.koeln.fae.microservice_dementiell_veraenderter.MicroserviceDementiellVeraenderterApplicationTests;
import de.th.koeln.fae.microservice_dementiell_veraenderter.models.*;
import de.th.koeln.fae.microservice_dementiell_veraenderter.repositories.DVPRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DVPTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MicroserviceDementiellVeraenderterApplicationTests.class);

    @Autowired
    private DVPRepository dvpRepository;

    private DementiellVeraenderter initializeDVP(){
        final DementiellVeraenderter dvp = new DementiellVeraenderter();

        List<Ereignis> ereignisList = new ArrayList<Ereignis>();
        ereignisList.add(new Ereignis(new Timestamp(System.currentTimeMillis()), "Beschreibung"));

        dvp.setNachname(new Nachname("Mustermann"));
        dvp.setVorname(new Vorname("Max"));
        dvp.setAlter(new Alter(89));
        dvp.setBild(new Bild("Pfad"));
        dvp.setEinwilligung(new Einwilligung("Ich moechte das nicht!"));
        dvp.setEreignisprotokoll(ereignisList);

        return dvp;
    }

    @Test
    public void createDVP(){
        DementiellVeraenderter dvp = initializeDVP();

        LOGGER.info("DVP to create: " + dvp.toString());

        final DementiellVeraenderter savedDVP = this.dvpRepository.save(dvp);

        assertNotNull(savedDVP);

        LOGGER.info("DVP was successfully created: " + dvp.toString());
    }

    @Test
    public void readDVP() {
        DementiellVeraenderter dvp = initializeDVP();

        LOGGER.info("DVP to read: " + dvp.toString());

        final DementiellVeraenderter savedDVP = this.dvpRepository.save(dvp);

        assertNotNull(savedDVP);
        assertNotNull(savedDVP.getId());
        assertEquals(dvp.getNachname(), savedDVP.getNachname());
        assertEquals(dvp.getVorname(), savedDVP.getVorname());
        assertEquals(dvp.getAlter(), savedDVP.getAlter());
        assertEquals(dvp.getBild(), savedDVP.getBild());
        assertEquals(dvp.getEinwilligung(), savedDVP.getEinwilligung());

        LOGGER.info("DVP was read: " + savedDVP.toString());

        this.dvpRepository.findAllById(savedDVP.getId());
    }

    @Test
    public void updateDVP(){
        DementiellVeraenderter dvp = initializeDVP();

        this.dvpRepository.save(dvp);

        LOGGER.info("DVP to update: " + dvp.toString());

        dvpRepository.findById(dvp.getId()).get().setVorname(new Vorname("Maximilian"));
        dvpRepository.findById(dvp.getId()).get().setNachname(new Nachname("Muster"));
        dvpRepository.findById(dvp.getId()).get().setBild(new Bild("Neuer Pfad"));
        dvpRepository.findById(dvp.getId()).get().setAlter(new Alter(90));
        dvpRepository.findById(dvp.getId()).get().setEinwilligung(new Einwilligung("Ich möchte das vielleicht."));

        dvp.getEreignisprotokoll().add(new Ereignis(new Timestamp(System.currentTimeMillis()), "Beschreibung"));
        dvpRepository.findById(dvp.getId()).get().setEreignisprotokoll(dvp.getEreignisprotokoll());

        assertEquals(dvpRepository.findById(dvp.getId()).get().getAlter(), new Alter(90));
        assertEquals(dvpRepository.findById(dvp.getId()).get().getVorname(), new Vorname("Maximilian"));
        assertEquals(dvpRepository.findById(dvp.getId()).get().getNachname(), new Nachname("Muster"));
        assertEquals(dvpRepository.findById(dvp.getId()).get().getBild().getPfad(), "Neuer Pfad");
        assertEquals(dvpRepository.findById(dvp.getId()).get().getEinwilligung().getText(), "Ich möchte das vielleicht.");
        assertEquals(dvpRepository.findById(dvp.getId()).get().getEreignisprotokoll(), dvp.getEreignisprotokoll());

        LOGGER.info("DVP was updated: " + dvp.toString());
    }

    @Test
    public void deleteDVP(){
        DementiellVeraenderter dvp = initializeDVP();

        final DementiellVeraenderter savedDVP = this.dvpRepository.save(dvp);

        LOGGER.info("DVP to delete: " + dvp.toString());

        assertNotNull(savedDVP);

        this.dvpRepository.deleteById(savedDVP.getId());

        assertEquals(dvpRepository.findById(savedDVP.getId()).isPresent(), false);

        LOGGER.info("DVP deleted: " + dvp.toString());
    }
}