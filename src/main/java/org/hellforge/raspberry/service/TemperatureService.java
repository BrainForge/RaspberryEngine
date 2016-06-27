package org.hellforge.raspberry.service;

import org.hellforge.raspberry.entity.TemperatureEntity;
import org.hellforge.raspberry.mongoRepository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton Afanasyeu on 27.06.16.
 */
@Transactional
@Service
public class TemperatureService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    public List<TemperatureEntity> getAllThermometer(){
        return temperatureRepository.findAll();
    }

    public TemperatureEntity save(TemperatureEntity thermometerEntity){
        return temperatureRepository.save(thermometerEntity);
    }
}
