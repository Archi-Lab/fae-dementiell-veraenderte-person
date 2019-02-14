package de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
public class Alter {

    @Getter
    @Setter
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

    @Override
    public boolean equals(Object other){
        return other.getClass() == this.getClass() && ((Alter)other).alter == this.alter;
    }
}
