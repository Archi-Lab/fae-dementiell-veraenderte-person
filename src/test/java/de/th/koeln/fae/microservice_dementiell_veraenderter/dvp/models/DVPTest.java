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

        List<Faehigkeit> faehigkeitList = new ArrayList<Faehigkeit>();
        faehigkeitList.add(new Faehigkeit("Bus fahren", "Nur noch mit Helm."));

        List<Kalendereintrag> kalendereintragList = new ArrayList<Kalendereintrag>();
        kalendereintragList.add(new Kalendereintrag("Zahnarzt", "Zähne ansehen", new Timestamp(System.currentTimeMillis())));

        List<Position> positionList = new ArrayList<Position>();
        positionList.add(new Position(938383, 393939, new Timestamp(System.currentTimeMillis())));

        dvp.setSurname("Mustermann");
        dvp.setForename("Max");
        dvp.setAge(89);
        dvp.setBild(new Bild("Pfad"));
        dvp.setEinwilligung(new Einwilligung("Ich moechte das nicht!"));
        dvp.setEreignisse(ereignisList);
        dvp.setFaehigkeiten(faehigkeitList);
        dvp.setKalendereintraege(kalendereintragList);
        dvp.setPositionsdaten(positionList);

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
        assertEquals(dvp.getSurname(), savedDVP.getSurname());
        assertEquals(dvp.getForename(), savedDVP.getForename());
        assertEquals(dvp.getAge(), savedDVP.getAge());
        assertEquals(dvp.getBild(), savedDVP.getBild());
        assertEquals(dvp.getEinwilligung(), savedDVP.getEinwilligung());
        assertEquals(dvp.getFaehigkeiten(), savedDVP.getFaehigkeiten());
        assertEquals(dvp.getKalendereintraege(), savedDVP.getKalendereintraege());
        assertEquals(dvp.getPositionsdaten(), savedDVP.getPositionsdaten());

        LOGGER.info("DVP was read: " + savedDVP.toString());

        this.dvpRepository.findAllById(savedDVP.getId());
    }

    @Test
    public void updateDVP(){

        DementiellVeraenderter dvp = initializeDVP();

        this.dvpRepository.save(dvp);

        LOGGER.info("DVP to update: " + dvp.toString());

        dvpRepository.findById(dvp.getId()).get().setForename("Maximilian");
        dvpRepository.findById(dvp.getId()).get().setSurname("Muster");
        dvpRepository.findById(dvp.getId()).get().setBild(new Bild("Neuer Pfad"));
        dvpRepository.findById(dvp.getId()).get().setAge(90);
        dvpRepository.findById(dvp.getId()).get().setEinwilligung(new Einwilligung("Ich möchte das vielleicht."));
        dvp.getFaehigkeiten().add(new Faehigkeit("Auto fahren", "Lieber nicht."));
        dvpRepository.findById(dvp.getId()).get().setFaehigkeiten(dvp.getFaehigkeiten());
        dvp.getEreignisse().add(new Ereignis(new Timestamp(System.currentTimeMillis()), "Beschreibung"));
        dvpRepository.findById(dvp.getId()).get().setEreignisse(dvp.getEreignisse());
        dvp.getKalendereintraege().add(new Kalendereintrag("Zahnarzt", "Zähne ansehen", new Timestamp(System.currentTimeMillis())));
        dvpRepository.findById(dvp.getId()).get().setKalendereintraege(dvp.getKalendereintraege());
        dvp.getPositionsdaten().add(new Position(938383, 393939, new Timestamp(System.currentTimeMillis())));
        dvpRepository.findById(dvp.getId()).get().setPositionsdaten(dvp.getPositionsdaten());


        assertEquals(dvpRepository.findById(dvp.getId()).get().getAge(), 90);
        assertEquals(dvpRepository.findById(dvp.getId()).get().getForename(), "Maximilian");
        assertEquals(dvpRepository.findById(dvp.getId()).get().getSurname(), "Muster");
        assertEquals(dvpRepository.findById(dvp.getId()).get().getBild().getPfad(), "Neuer Pfad");
        assertEquals(dvpRepository.findById(dvp.getId()).get().getEinwilligung().getText(), "Ich möchte das vielleicht.");
        assertEquals(dvpRepository.findById(dvp.getId()).get().getFaehigkeiten(), dvp.getFaehigkeiten());
        assertEquals(dvpRepository.findById(dvp.getId()).get().getPositionsdaten(), dvp.getPositionsdaten());
        assertEquals(dvpRepository.findById(dvp.getId()).get().getKalendereintraege(), dvp.getKalendereintraege());
        assertEquals(dvpRepository.findById(dvp.getId()).get().getEreignisse(), dvp.getEreignisse());

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
