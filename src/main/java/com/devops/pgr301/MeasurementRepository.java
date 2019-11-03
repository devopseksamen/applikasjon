package com.devops.pgr301;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MeasurementRepository extends CrudRepository<Measurement, Integer> {

    @Query("select m from Measurement m where m.geigerCounterId = ?1")
    List<Measurement> findByGeigerCounterId(int geigerId);
}
