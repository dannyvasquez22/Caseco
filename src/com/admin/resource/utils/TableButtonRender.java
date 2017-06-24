package com.admin.resource.utils;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/** * @author DANNY VASQUEZ RAFAEL */

public class TableButtonRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        if(o instanceof JButton) { // Puede ser JLabel o JComboBox o mas ...
            JButton btn = (JButton)o;
            return btn;
        }
        
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
    }
    
}
