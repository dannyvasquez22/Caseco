package com.admin.resource.utils;

import java.io.IOException;
import org.apache.log4j.Logger;

public class ShutdownPC {
    final static Logger logger = Logger.getLogger(ShutdownPC.class);
    
    public static void exec(String cmd) { 
        try { 
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException e) { 
            logger.error("Failed al apagar PC.");         
        } 
    } 
}
