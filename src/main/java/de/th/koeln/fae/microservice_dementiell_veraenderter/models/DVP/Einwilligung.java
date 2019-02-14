package de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP;

import javax.persistence.Embeddable;

/*
Value-Object im DVP-Aggregate (DVP <- Einwilligung)
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
