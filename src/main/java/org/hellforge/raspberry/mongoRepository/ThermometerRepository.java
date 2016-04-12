package org.hellforge.raspberry.mongoRepository;

import org.hellforge.raspberry.entity.ThermometerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Anton Afanasyeu on 12.04.16.
 */
@Repository
public interface ThermometerRepository extends MongoRepository<ThermometerEntity, String> {

}

