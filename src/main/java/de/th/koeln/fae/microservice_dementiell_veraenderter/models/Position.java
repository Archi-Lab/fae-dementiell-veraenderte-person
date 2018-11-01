package de.th.koeln.fae.microservice_dementiell_veraenderter.models;

import javax.persistence.Embeddable;
import java.sql.Date;
import java.sql.Time;

@Embeddable
public class Position {

    private double longitude;
    private double latitude;
    private Time time;
    private Date date;

    public Position(double longitude, double latitude, Time time, Date date) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
        this.date = date;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
