package com.devops.pgr301;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static io.micrometer.core.instrument.Metrics.summary;
import static org.slf4j.LoggerFactory.getLogger;

@RestController
@Timed
public class Controller {

    private static final Logger LOG = getLogger(Controller.class);
    private MeterRegistry meterRegistry;

    private MeasurementService measurementService;

    private GeigerCounterService geigerCounterService;

    @Autowired
    public Controller (MeterRegistry meterRegistry, MeasurementService measurementService, GeigerCounterService geigerCounterService) {
        this.meterRegistry = meterRegistry;
        this.measurementService = measurementService;
        this.geigerCounterService = geigerCounterService;
    }

    @Timed
    @PostMapping("/devices")
    public GeigerCounter createDevice() {
        meterRegistry.counter("devices.created").increment();
        meterRegistry.gauge("number.of.devices", geigerCounterService.getGeigerCounters().size());
        LOG.info("Device created");
        return geigerCounterService.createGeigerCounter();
    }

    @PostMapping("/devices/{deviceId}/measurements")
    public void createMeasurement(@RequestBody Measurement measurement, @PathVariable String deviceId) {
        meterRegistry.counter("measurements_created").increment();
        meterRegistry.summary("request.size");
        measurementService.saveMeasurement(measurement);
    }

    @Timed(value = "all.measurements", longTask = true)
    @GetMapping("/devices/{id}/measurements")
    public List<Measurement> getMeasurementsByGeigerId(int geigerId, @PathVariable String id) {
        return measurementService.getAllMeasurementsByGeigerId(geigerId);
    }

    @Timed(value = "all.devices", longTask = true)
    @GetMapping("/devices")
    public List<GeigerCounter> getDevices() {
        meterRegistry.summary("response.size");
        return geigerCounterService.getGeigerCounters();
    }
}
