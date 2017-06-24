package com.admin.resource.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class MyRenderActive extends DefaultTableCellRenderer {
        
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean hasFocus, int row, int column) {
        String estado = table.getValueAt(row, column).toString();
        if (selected) {
            this.setBackground(new Color(176,196,222));
        } else {
            this.setBackground(Color.white);
        }
                
        if (estado.equals("Activo") || estado.equals("Conectado")) {
            this.setForeground(Color.BLUE);
        } else {
            this.setForeground(Color.RED);
        }
                
        this.setText( (String) value );
        this.setFont(new Font( "Verdana",Font.PLAIN ,12 ));
        this.setHorizontalAlignment(SwingConstants.CENTER);
//        this.setForeground( (selected)?new Color(0,0,0):new Color(0,0,0) );           // segundo color 32,17,32
        
        return this;
    }

}
