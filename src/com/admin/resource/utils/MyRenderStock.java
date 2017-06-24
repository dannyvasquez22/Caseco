package com.admin.resource.utils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class MyRenderStock extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ) {
        float stockCritico = Float.valueOf(table.getValueAt(row, 4).toString());
        float stockActual = Float.valueOf(table.getValueAt(row, 3).toString());
        if (selected) {
            this.setBackground(new Color(176,196,222));
        } else {
            this.setBackground(Color.white);
        }
        
        if ((stockActual/2) <= stockCritico) {
            this.setBackground(new Color(0,153,0));
        }
        
        if (stockActual <= stockCritico) {
            this.setBackground( Color.RED/*new Color( 50, 153 , 254)*/ );
        }
        if (value instanceof String) {
            
        } else {
            this.setHorizontalAlignment(SwingConstants.RIGHT);
        }
        
        this.setText(String.valueOf(value));
        this.setFont(new Font( "Verdana",Font.PLAIN ,12 ));
        this.setForeground( (selected)?new Color(0,0,0):new Color(0,0,0) );           // segundo color 32,17,32

        return this;
    }
}
