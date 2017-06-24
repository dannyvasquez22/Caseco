package com.admin.resource.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class Clock extends Thread {
    JLabel lblReloj;
    JLabel lblFecha;	

    public Clock(JLabel lblReloj, JLabel lblFecha) {
        this.lblReloj = lblReloj;
        this.lblFecha = lblFecha;
    }

    public void run() {  // funcionamiento del reloj
        while (true) {
            Date hoy = new Date();
            SimpleDateFormat horita = new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat fechita = new SimpleDateFormat("EEEEEEEEE, dd 'de' MMMMM 'de' yyyy");
            lblFecha.setText(fechita.format(hoy));
            lblReloj.setText(horita.format(hoy));
                       
            try {
                sleep(1000); // demora de 1 segundo 
            } catch (Exception ex) { }
        }
    }
}