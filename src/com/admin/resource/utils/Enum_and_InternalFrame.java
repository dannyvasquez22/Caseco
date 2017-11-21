package com.admin.resource.utils;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/** @author DANNY VASQUEZ RAFAEL */

public enum Enum_and_InternalFrame {
    /* //Ejemplo de uso de enum
        OptionValues mode= OptionValues.INSERT;
        int result = CategoriaBL.getInstance().insert(mode.getValue(), objCategoria);
    */
    INSERT("INSERT", 1), UPDATE("UPDATE", 2), DELETE("DELETE", 3);

    private final String key;
    private final int value;

    private Enum_and_InternalFrame(String key, int value) {
        this.key = key;
        this.value = value;
    }
    
    
    public String getKey(){
        return this.key;
    }
    
    public int getValue(){
        return this.value;
    }
    
    
    
    
    // método para saber si un JInternalFrame ya fue creado
    /* //Ejemplo de consumo en un jframe, donde dskContenedor es un desktopPane
        frmKardex ventana = new frmKardex();
        if (!ExampleEnum_InternalFrame.getInstance().isJInternalFrameOpen(ventana, dskContenedor)) {
            dskContenedor.add(ventana);
            ventana.setVisible(true);
        }
    */
    public boolean isJInternalFrameOpen(Object obj, JDesktopPane dskContenedor) {                
        JInternalFrame[] objActivos = dskContenedor.getAllFrames();
        boolean cerrado = false;
        for (JInternalFrame frame : objActivos) {
            if (frame.getClass() == obj.getClass()) {
                cerrado = true;
                break;
            }
        }
        return cerrado;
    }
}
