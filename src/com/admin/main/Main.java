package com.admin.main;

import com.admin.view.init.SplashScreen;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.PropertyConfigurator;

public class Main {    
    
    public static void main(String[] args) {        
        String appPath = System.getProperties().getProperty("user.dir");
        String pathLog = appPath + "\\config\\log4j.properties";
        PropertyConfigurator.configure(pathLog);
        
        String imageURL = "http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/captcha?accion=image";
        String url_antigua = "http://www.sunat.gob.pe/cl-ti-itmrconsruc/captcha?accion=image";
        String result = "";
        URL url;

        ITesseract instance = new Tesseract();

        try {
            url = new URL(url_antigua);
            BufferedImage img = ImageIO.read(url);
            result = instance.doOCR(img);
            System.out.println(result);
        } catch (TesseractException | IOException e) {
            System.err.println(e.getMessage());
        }
        
        new Thread(new SplashScreen()).start();
    }    
}
