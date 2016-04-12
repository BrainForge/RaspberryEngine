package org.hellforge.raspberry.service;

import org.hellforge.raspberry.entity.ThermometerEntity;
import org.hellforge.raspberry.mongoRepository.ThermometerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton Afanasyeu on 17.03.16.
 */
@Transactional
@Service
public class ThermometerService {

    @Autowired
    ThermometerRepository thermometerRepository;

    public List<ThermometerEntity> getAllThermometer(){
        return thermometerRepository.findAll();
    }

    public ThermometerEntity save(ThermometerEntity thermometerEntity){
        return thermometerRepository.save(thermometerEntity);
    }
}
