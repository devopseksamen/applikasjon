package com.devops.pgr301;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public class Api {


    @RestController
    @Timed
    public static class Controller {

        @Autowired
        MeterRegistry meterRegistry;

        @Autowired
        MeasurementService measurementService;

        @Autowired
        GeigerCounterService geigerCounterService;

        @PostMapping("/devices")
        public GeigerCounter createDevice (){
            return geigerCounterService.createGeigerCounter();
        }

        @PostMapping("/devices/{deviceId}/measurements")
        public void createMeasurement(@RequestBody Measurement measurement) {
            measurementService.saveMeasurement(measurement);
        }

        @GetMapping("/devices/{id}/measurements")
        public List<Measurement> getMeasurementsByGeigerId(int geigerId) {
            return measurementService.getAllMeasurementsByGeigerId(geigerId);
        }

        @GetMapping("/devices")
        public List<GeigerCounter> getDevices() {
            meterRegistry.counter("created_devices").increment();
            return geigerCounterService.getGeigerCounters();
        }
    }
}
