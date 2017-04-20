package com.esportbook.utils;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Created by hhkmac on 2017/4/20.
 */
public class ExecLinuxCMDUtil {
    public static final  ExecLinuxCMDUtil instance = new ExecLinuxCMDUtil();

    public static Object exec(String cmd) {
        try {
            String[] cmdA = { "/bin/sh", "-c", cmd };
            Process process = Runtime.getRuntime().exec(cmdA);
            LineNumberReader br = new LineNumberReader(new InputStreamReader(
                    process.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
