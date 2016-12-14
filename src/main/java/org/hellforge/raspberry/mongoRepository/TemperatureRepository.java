package org.hellforge.raspberry.mongoRepository;

import org.hellforge.raspberry.entity.TemperatureEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Anton Afanasyeu on 27.06.16.
 */
public interface TemperatureRepository extends MongoRepository<TemperatureEntity, String> {

    List<TemperatureEntity> findByIdDeviceOrderByDateDesc(String id, Pageable pageable);

}
