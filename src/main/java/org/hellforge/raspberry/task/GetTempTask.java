package org.hellforge.raspberry.task;

import org.hellforge.raspberry.entity.ThermometerEntity;
import org.hellforge.raspberry.service.ThermometerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Anton Afanasyeu on 17.03.16.
 */
@Service
public class GetTempTask {

    @Autowired
    ThermometerService thermometerService;

    @Scheduled(fixedRate=5000)
    public void printMessage() {

        for(ThermometerEntity thermometerEntity: thermometerService.getAllThermometer()){
            thermometerEntity.setTemp(getTemp(thermometerEntity.getDeviceId()));
            thermometerService.save(thermometerEntity);
        }

    }

    private double getTemp(String tempId){
        return 25.134;
    }
}
