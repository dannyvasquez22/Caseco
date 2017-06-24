package com.admin.controller.tablemodel;

import com.admin.entity.dto.MarcaDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TMarca  extends AbstractTableModel {
    private ArrayList<MarcaDTO> marcas = null;
    private final Class[] tiposColumn = {String.class, String.class};
    private final String []titulos = {"NOMBRE", "DESCRIPCIÓN"};
    
    public TMarca(ArrayList<MarcaDTO> arrayList) {
       marcas = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return marcas.size();
    }

    @Override
    public int getColumnCount() {
       return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.marcas.get(rowIndex).getNombre();
            case 1: return this.marcas.get(rowIndex).getDescripcion();
            default: return this.marcas.get(rowIndex);
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
            case 0: marcas.get(rowIndex).setNombre(String.valueOf(aValue)); break;
            case 1: marcas.get(rowIndex).setDescripcion(String.valueOf(aValue)); break;
        }
    }
}

