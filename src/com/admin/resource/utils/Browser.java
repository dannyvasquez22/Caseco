package com.admin.resource.utils;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;

public class Browser {

    final static Logger logger = Logger.getLogger(Browser.class);
    
    public static void openURL(String url) {
        String osName = System.getProperty("os.name");
        try {
            if (osName.startsWith("MacOS")) {
                Class nav = Class.forName("com.apple.eio.FileManager");
                Method openURL = nav.getDeclaredMethod("openURL", new Class[]{String.class});
                openURL.invoke(null, new Object[]{url});
            } else if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler   " + url);
            } else {
                String[] browsers = {"firefox", "opera", "mozilla"};
                String browser = null;
                for (String browser1 : browsers) {
                    if (Runtime.getRuntime().exec(new String[]{"which", browser1}).waitFor() == 0) {
                        browser = browser1;
                    }
                    if (browser == null) {
                        throw new Exception("No se puede abrir el navegador web");
                    } else {
                        Runtime.getRuntime().exec(new String[]{browser, url});
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getStackTrace());
        }
    }
}
