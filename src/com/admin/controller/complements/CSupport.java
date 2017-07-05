package com.admin.controller.complements;

import com.admin.resource.utils.Global;
import com.admin.view.complements.Support;
import java.awt.event.MouseAdapter;

/** * @author DANNY VASQUEZ RAFAEL */

public class CSupport extends MouseAdapter {
    
    private final Support view_support;
    
    public CSupport (Support viewSupport) {
        this.view_support = viewSupport;
        this.view_support.panelAyuda.addMouseListener(this);
        this.view_support.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                view_support.dispose();
            }
        });
    }
    
    public void iniciar() {
        view_support.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        view_support.setResizable(false);
        view_support.setIconImage(Global.ICON_IMAGE);
        view_support.setCursor(Global.CURSOR);
        view_support.setTitle("Contacto para Sistemas");
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        view_support.dispose();
    }
}
