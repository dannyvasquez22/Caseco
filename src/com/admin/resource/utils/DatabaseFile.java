package com.admin.resource.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class DatabaseFile {

    final static Logger logger = Logger.getLogger(DatabaseFile.class);
    
    public static String[] read() {
        
        String[] settings = new String[5];
        
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String[] data;
       
        try {
            archivo = new File("config.dat");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            int i = 0;
            while (br.ready()) {
                data = br.readLine().split("=");
                settings[i] = data[1];
                i++;
            }

        } catch (IOException e) {
            logger.error(e.getStackTrace());
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                logger.error(e2.getStackTrace());
            }
        }
        
        return settings;
    }
 }
