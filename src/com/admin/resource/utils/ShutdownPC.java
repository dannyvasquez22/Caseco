package com.admin.resource.utils;

import java.io.IOException;

public class ShutdownPC {
    
    public static void exec(String cmd) { 
        try { 
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException e) { 
            System.out.println("Failed");         
        } 
    } 
}
