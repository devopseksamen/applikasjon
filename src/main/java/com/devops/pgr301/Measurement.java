package com.devops.pgr301;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Measurement {

    @Id
    @GeneratedValue
    private int id;


    private int geigerCounterId;
    private int lat;
    private int lng;
    private int sievert;


    public  Measurement(){
        super();
    }

    public Measurement(int geigerCounterId, int lat, int lng, int sievert) {
        this.geigerCounterId = geigerCounterId;
        this.lat = lat;
        this.lng = lng;
        this.sievert = sievert;
    }


    public double getLat() {
        return lat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeigerCounterId() {
        return geigerCounterId;
    }

    public void setGeigerCounterId(int geigerCounterId) {
        this.geigerCounterId = geigerCounterId;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public int getSievert() {
        return sievert;
    }

    public void setSievert(int sievert) {
        this.sievert = sievert;
    }


}
