package de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP;

import javax.persistence.Embeddable;

/**
Attribut Einwilligung der DVP Entität sowie Value-Object im DVP-Aggregate. Wird durch diese Klasse explizit gemacht.
 */
@Embeddable
public class Einwilligung {

    private String text;

    public Einwilligung(){

    }

    public Einwilligung(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
