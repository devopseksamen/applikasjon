package com.devops.pgr301;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GeigerCounter {

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

}
