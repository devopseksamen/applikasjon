package com.devops.pgr301;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    public List<Measurement> getAllMeasurementsByGeigerId(int id) {
        List<Measurement> measurements;
        measurements = measurementRepository.findByGeigerCounterId(id);
        return measurements;
    }

    public void saveMeasurement(Measurement measurement) {
        measurementRepository.save(measurement);
    }
}
