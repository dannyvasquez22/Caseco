package com.admin.scrap;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;

/** * @author DANNY */
public class Sunat {
    
    @Test
    public void test() {
//        System.setProperty("jna.library.path", "32".equals(System.getProperty("sun.arch.data.model")) ? "lib/win32-x86" : "lib/win32-x86-64");
        
        String imageURL = "http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/captcha?accion=image";
        String url_antigua = "http://www.sunat.gob.pe/cl-ti-itmrconsruc/captcha?accion=image";
        String result = "";
        URL url;

        ITesseract instance = new Tesseract();

        try {
            url = new URL(imageURL);
            BufferedImage img = ImageIO.read(url);
            result = instance.doOCR(img);
            System.out.println(result);
        } catch (TesseractException | IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
