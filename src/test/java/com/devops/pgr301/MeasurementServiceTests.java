package com.devops.pgr301;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeasurementServiceTests {

    @Autowired
    MeasurementService measurementService;

    @Test
    public void saveMeasurementAndGetMeasurements(){
        Measurement measurement1 = new Measurement(1,2,3,4);
        Measurement measurement2 = new Measurement(1,3,3,4);

        measurementService.saveMeasurement(measurement1);
        measurementService.saveMeasurement(measurement2);

        assertThat(measurementService.getAllMeasurementsByGeigerId(1)).isNotNull();
        assertThat(measurementService.getAllMeasurementsByGeigerId(2).isEmpty());
    }
}
