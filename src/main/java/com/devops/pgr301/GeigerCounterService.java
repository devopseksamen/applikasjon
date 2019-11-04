package com.devops.pgr301;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeigerCounterService {

    @Autowired
    GeigerCounterRepository geigerCounterRepository;

    public List<GeigerCounter> getGeigerCounters() {
        List<GeigerCounter> geigerCounters = new ArrayList<>();
        geigerCounterRepository.findAll().forEach(geigerCounters::add);
        return geigerCounters;
    }

    public GeigerCounter createGeigerCounter() {
        GeigerCounter geigerCounter = new GeigerCounter();
        geigerCounterRepository.save(geigerCounter);
        return geigerCounter;
    }
}
