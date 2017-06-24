package com.admin.controller.tablemodel;

import com.admin.entity.dto.TiendaProductoDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TTiendaProducto  extends AbstractTableModel {
    private ArrayList<TiendaProductoDTO> tiendaProducto = null;
    private final Class[] tiposColumn = {String.class, String.class};
    private final String []titulos = {"FECHA INICIO", "FECHA FIN"};
    
    public TTiendaProducto(ArrayList<TiendaProductoDTO> arrayList) {
       tiendaProducto = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return tiendaProducto.size();
    }

    @Override
    public int getColumnCount() {
       return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.tiendaProducto.get(rowIndex).getFechaInicio();
            case 1: return this.tiendaProducto.get(rowIndex).getFechaFin();
            default: return this.tiendaProducto.get(rowIndex);
        }
    }
   
    @Override
    public Class getColumnClass(int columnIndex) {
        return tiposColumn[columnIndex];
    } 
    
    @Override
    public String getColumnName(int valorColumn) {
        return titulos[valorColumn];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, rowIndex);
        switch (columnIndex) {
            case 0: tiendaProducto.get(rowIndex).setFechaInicio(String.valueOf(aValue)); break;
            case 1: tiendaProducto.get(rowIndex).setFechaFin(String.valueOf(aValue)); break;
        }
    }
}

