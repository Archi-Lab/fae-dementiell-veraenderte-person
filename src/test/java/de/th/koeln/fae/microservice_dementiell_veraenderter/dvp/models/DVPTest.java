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

        final DementiellVeraenderter savedDVP = this.dvpRepository.save(dvp);

        dvpRepository.findById(dvp.getId()).get().setBild(new Bild("Neuer Pfad"));
        dvpRepository.findById(dvp.getId()).get().setAge(90);


    }
}
