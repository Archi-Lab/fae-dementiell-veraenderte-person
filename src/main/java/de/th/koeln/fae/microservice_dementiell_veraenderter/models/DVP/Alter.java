package de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP;

import javax.persistence.Embeddable;

/*
Value-Object im DVP-Aggregate (DVP <- Alter)
 */
@Embeddable
public class Alter {

    private int alter;

    public Alter(){
    }

    public Alter(int alter){

        if(alter > 150 && alter <= 0) {
            throw new IllegalArgumentException("Es ist sehr unwahrscheinlich, dass ein Mensch älter als 150, oder jünger" +
                    " als 0 Jahre ist.");
        }
        this.alter = alter;
    }

    @Override
    public boolean equals(Object other){
        return other.getClass() == this.getClass() && ((Alter)other).alter == this.alter;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }
}
