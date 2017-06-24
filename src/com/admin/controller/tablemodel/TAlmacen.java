package com.admin.controller.tablemodel;

import com.admin.entity.dto.AlmacenDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TAlmacen  extends AbstractTableModel {
    private ArrayList<AlmacenDTO> almacenes = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class};
    private final String []titulos = {"CODIGO", "NOMBRE", "DIRECCIÓN"};
    
    public TAlmacen(ArrayList<AlmacenDTO> arrayList) {
       almacenes = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return almacenes.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.almacenes.get(rowIndex).getCodigo();
            case 1: return this.almacenes.get(rowIndex).getNombre();
            case 2: return this.almacenes.get(rowIndex).getDireccion();
            default: return this.almacenes.get(rowIndex);
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
            case 0: almacenes.get(rowIndex).setCodigo(Integer.parseInt(String.valueOf(aValue))); break;
            case 1: almacenes.get(rowIndex).setNombre(String.valueOf(aValue)); break;           
            case 2: almacenes.get(rowIndex).setDireccion(String.valueOf(aValue)); break;
        }
    }
}

