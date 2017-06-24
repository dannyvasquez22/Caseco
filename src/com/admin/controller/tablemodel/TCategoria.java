package com.admin.controller.tablemodel;

import com.admin.entity.dto.CategoriaDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TCategoria  extends AbstractTableModel {
    private ArrayList<CategoriaDTO> categorias = null;
    private final Class[] tiposColumn = {String.class, String.class};
    private final String []titulos = {"NOMBRE", "DIRECCIÓN"};
    
    public TCategoria(ArrayList<CategoriaDTO> arrayList) {
       categorias = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return categorias.size();
    }

    @Override
    public int getColumnCount() {
       return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.categorias.get(rowIndex).getNombre();
            case 1: return this.categorias.get(rowIndex).getDescripcion();
            default: return this.categorias.get(rowIndex);
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
            case 0: categorias.get(rowIndex).setNombre(String.valueOf(aValue)); break;
            case 1: categorias.get(rowIndex).setDescripcion(String.valueOf(aValue)); break;
        }
    }
}

