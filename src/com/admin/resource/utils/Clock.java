package com.admin.resource.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import org.apache.log4j.Logger;

public class Clock extends Thread {
    
    final static Logger logger = Logger.getLogger(Clock.class);
    JLabel lblReloj;
    JLabel lblFecha;	

    public Clock(JLabel lblReloj, JLabel lblFecha) {
        this.lblReloj = lblReloj;
        this.lblFecha = lblFecha;
    }

    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {  // funcionamiento del reloj
        while (true) {
            Date hoy = new Date();
            SimpleDateFormat horita = new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat fechita = new SimpleDateFormat("EEEEEEEEE, dd 'de' MMMMM 'de' yyyy");
            lblFecha.setText(fechita.format(hoy));
            lblReloj.setText(horita.format(hoy));
                       
            try {
                sleep(1000); // demora de 1 segundo 
            } catch (InterruptedException ex) { 
                logger.error(ex.getStackTrace());
            }
        }
    }
}