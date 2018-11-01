package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.Embeddable;

@Embeddable
public class Faehigkeit {

    private String name;
    private String description;

    public Faehigkeit(){

    }

    public Faehigkeit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
