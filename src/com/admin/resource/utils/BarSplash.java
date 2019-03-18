package com.admin.resource.utils;

import javax.swing.JProgressBar;
import org.apache.log4j.Logger;

public class BarSplash extends Thread {
    
    final static Logger logger = Logger.getLogger(BarSplash.class);
    private int num = 0;
    private final JProgressBar Barra;

    public BarSplash(JProgressBar Barra) {
        this.Barra = Barra;
    }

    private void llenarBarra() {
        if (Barra.getValue() <= 100) {
            num += 10;
            Barra.setValue(num);
            Barra.setStringPainted(true);
        } else {
            Barra.setValue(0);
        }
    }

    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        while (true) {
            try {
                Thread.sleep(120);
                llenarBarra();
            } catch (InterruptedException ex) {  
                logger.error(ex.getStackTrace());
            }
        }
    }
}
