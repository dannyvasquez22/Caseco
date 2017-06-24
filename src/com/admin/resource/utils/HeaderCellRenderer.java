package com.admin.resource.utils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class HeaderCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JComponent jcomponent = null;

        if (value instanceof String) {
            jcomponent = new JLabel((String) value);
            ((JLabel)jcomponent).setFont( new Font( "Verdana",Font.BOLD ,12 ) );
            ((JLabel)jcomponent).setForeground(Color.WHITE);
            ((JLabel)jcomponent).setHorizontalAlignment( SwingConstants.CENTER );
            ((JLabel)jcomponent).setSize( 15, jcomponent.getWidth() );
            ((JLabel)jcomponent).setPreferredSize( new Dimension(4, jcomponent.getWidth())  );
        }

        //jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(221, 211, 211)));
        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 100, 0)));
        jcomponent.setOpaque(true);
        //jcomponent.setBackground( new Color(236,234,219) );
        jcomponent.setBackground(new Color(0,153,0));
        jcomponent.setToolTipText("");

        return jcomponent;
    }
}
