package org.hellforge.raspberry.parser;

import org.springframework.stereotype.Component;

/**
 * Created by Anton Afanasyeu on 12/14/16.
 */
@Component
public class Parser {

    public boolean isEventModel(String str) {
        return str.contains("lumi.sensor_ht.v1") ||
                str.contains("lumi.sensor_switch.v2") ||
                str.contains("lumi.sensor_magnet.v2") ||
                str.contains("lumi.sensor_motion.v2");
    }

}
