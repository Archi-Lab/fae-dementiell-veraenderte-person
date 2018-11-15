package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.Embeddable;

@Embeddable
public class Alter {

    private int alter;

    public Alter(){

    }

    public Alter(int alter){

        if(alter > 150 && alter <= 0) {
            throw new IllegalArgumentException("Es ist sehr unwahrscheinlich, dass ein Mensch älter als 150, oder jünger" +
                    "als 0 Jahre ist.");
        }
        this.alter = alter;
    }

}
