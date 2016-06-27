package org.hellforge.raspberry.task;

import org.hellforge.raspberry.entity.TemperatureEntity;
import org.hellforge.raspberry.entity.ThermometerEntity;
import org.hellforge.raspberry.helper.Helper;
import org.hellforge.raspberry.service.TemperatureService;
import org.hellforge.raspberry.service.ThermometerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Anton Afanasyeu on 17.03.16.
 */
@Service
public class GetTempTask {

    @Autowired
    ThermometerService thermometerService;
    @Autowired
    TemperatureService temperatureService;

    @Scheduled(fixedRate=5000)
    public void insertTemp() throws IOException, InterruptedException {

        for(ThermometerEntity thermometerEntity: thermometerService.getAllThermometer()){
            Double temp = Helper.getTemp(thermometerEntity.getId());
            thermometerEntity.setTemp(temp);
            thermometerService.save(thermometerEntity);
            TemperatureEntity temperatureEntity = new TemperatureEntity(temp, new Date());
            temperatureService.save(temperatureEntity);
        }

    }

    @Scheduled(cron="*/5 * * * * *")
    public void insertTempForStatistic() throws IOException, InterruptedException {

        for(ThermometerEntity thermometerEntity: thermometerService.getAllThermometer()){
            TemperatureEntity temperatureEntity = new TemperatureEntity(thermometerEntity.getTemp(), new Date());
            temperatureService.save(temperatureEntity);
        }

    }
}
