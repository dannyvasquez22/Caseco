package com.admin.controller.complements;

import com.admin.resource.utils.Global;
import com.admin.view.complements.PCInformation;

/** * @author DANNY VASQUEZ RAFAEL */

public class CPCInformation {
    private final PCInformation view_pc;
    
    public CPCInformation (PCInformation viewPC) {
        this.view_pc = viewPC;
        this.view_pc.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                view_pc.dispose();
            }
        });
    }
    
    public void iniciar() {
        view_pc.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        view_pc.setResizable(false);
        view_pc.setIconImage(Global.ICON_IMAGE);
        view_pc.setCursor(Global.CURSOR);
        view_pc.setTitle("Información de Arquitectura");
        view_pc.lblQueComputadora.setText(System.getenv("COMPUTERNAME"));
        view_pc.lblQueUsuario.setText(System.getProperty("user.name"));
        view_pc.textProcesador.setText(System.getenv("PROCESSOR_IDENTIFIER"));
        view_pc.lblQueSO.setText(System.getProperty("os.name"));
        view_pc.lblQueJava.setText(System.getProperty("java.version"));
    }

}
