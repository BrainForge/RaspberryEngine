package org.hellforge.raspberry.task;

import org.hellforge.raspberry.entity.ThermometerEntity;
import org.hellforge.raspberry.helper.GetSystemOut;
import org.hellforge.raspberry.service.ThermometerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Anton Afanasyeu on 17.03.16.
 */
@Service
public class GetTempTask {

    @Autowired
    ThermometerService thermometerService;

    @Scheduled(fixedRate=5000)
    public void printMessage() throws IOException, InterruptedException {

        for(ThermometerEntity thermometerEntity: thermometerService.getAllThermometer()){
            thermometerEntity.setTemp(getTemp(thermometerEntity.getId()));
            thermometerService.save(thermometerEntity);
        }

    }

    private double getTemp(String tempId) throws IOException, InterruptedException {
        String str = GetSystemOut.getSystemOut("cat /sys/bus/w1/devices/"+tempId+"/w1_slave");
        str = str.substring(str.indexOf("t=")+2);
        return Integer.parseInt(str)/1000.0;
    }
}
