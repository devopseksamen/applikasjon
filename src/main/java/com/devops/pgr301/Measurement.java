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
    private float lat;
    private float lng;
    private float sievert;


    public  Measurement(){
        super();
    }

    public Measurement(int geigerCounterId, int lat, int lng, int sievert) {
        this.geigerCounterId = geigerCounterId;
        this.lat = lat;
        this.lng = lng;
        this.sievert = sievert;
    }


    public float getLat() {
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

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getSievert() {
        return sievert;
    }

    public void setSievert(float sievert) {
        this.sievert = sievert;
    }


}
