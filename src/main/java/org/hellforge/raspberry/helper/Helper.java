package org.hellforge.raspberry.helper;

import java.io.IOException;

/**
 * Created by Anton Afanasyeu on 27.06.16.
 */
public class Helper {

    public static double getTemp(String tempId) throws IOException, InterruptedException {
        String str = GetSystemOut.getSystemOut("cat /sys/bus/w1/devices/"+tempId+"/w1_slave");
        str = str.substring(str.indexOf("t=")+2);
        return Integer.parseInt(str)/1000.0;
    }

}
