package org.hellforge.raspberry.mongoRepository;

import org.hellforge.raspberry.entity.TemperatureEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Anton Afanasyeu on 27.06.16.
 */
public interface TemperatureRepository extends MongoRepository<TemperatureEntity, String> {
}
