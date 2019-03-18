package com.admin.resource.utils;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/** * @author DANNY VASQUEZ RAFAEL */
@SuppressWarnings("OverridableMethodCallInConstructor")
public class RenderTable extends JLabel implements TableCellRenderer {

    boolean isBordered = true;

    public RenderTable(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
        // Va a mostrar el botón solo en la última fila.
        // de otra forma muestra un espacio en blanco.
//        if (row == table.getModel().getRowCount() - 1) {
//            return new JButton("Agregar");
//        } else {
//            setBackground(new Color(0xffffff));
//            return this;
//        }        
        if (column == 8) {
            return new JButton("Edita");
        }
        return this;
    }
}
