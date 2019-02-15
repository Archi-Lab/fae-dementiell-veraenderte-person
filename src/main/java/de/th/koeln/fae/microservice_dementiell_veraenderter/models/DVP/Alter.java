package de.th.koeln.fae.microservice_dementiell_veraenderter.models.DVP;

import javax.persistence.Embeddable;

/**
Attribut Alter der DVP Entität sowie Value-Object im DVP-Aggregate. Wird durch diese Klasse explizit gemacht.
 */
@Embeddable
public class Alter {

    private int alter;

    //region Konstruktoren
    public Alter(){
    }

    public Alter(int alter){

        //Das eingegebene Alter prüfen.
        if(alter > 150 && alter <= 0) {
            throw new IllegalArgumentException("Es ist sehr unwahrscheinlich, dass ein Mensch älter als 150, oder jünger" +
                    " als 0 Jahre ist.");
        }
        this.alter = alter;
    }
    //endregion

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    @Override
    public boolean equals(Object other){
        return other.getClass() == this.getClass() && ((Alter)other).alter == this.alter;
    }
}
