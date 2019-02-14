package de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP;

import javax.persistence.*;

/*
Value-Object im DVP-Aggregate (DVP <- Bild)

Das Bild wird als Ressource abgelegt. Dieses Objekt soll einen relativen Pfad zu der Ressource enthalten (als String)
 */
@Embeddable
public class Bild {

    private String pfad;

    public Bild(){
    }

    public Bild(String pfad) {
        this.pfad = pfad;
    }

    public String getPfad() {
        return pfad;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }
}
