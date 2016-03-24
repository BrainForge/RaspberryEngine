package org.hellforge.raspberry.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by anton on 23.03.16.
 */
public class GetSystemOut {
    public static String getSystemOut(String str) throws IOException, InterruptedException {
        Runtime r = Runtime.getRuntime();
        Process p = r.exec(str);
        p.waitFor();
        BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        String out = "";
        while ((line = b.readLine()) != null) {
            out += line;
        }
    return out;
    }
}
