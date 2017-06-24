package com.admin.main;

import com.admin.view.init.SplashScreen;
import org.apache.log4j.PropertyConfigurator;

public class Main {    
    
    public static void main(String[] args) {        
        String appPath = System.getProperties().getProperty("user.dir");
        String pathLog = appPath + "\\config\\log4j.properties";
        PropertyConfigurator.configure(pathLog);
        new Thread(new SplashScreen()).start();
    }    
}
