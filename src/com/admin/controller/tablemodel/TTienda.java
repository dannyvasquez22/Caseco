package com.admin.controller.tablemodel;

import com.admin.model.dto.TiendaDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TTienda  extends AbstractTableModel {
    private ArrayList<TiendaDTO> tiendas = null;
    private final Class[] tiposColumn = {String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"CÓDIGO", "RUC", "RAZÓN SOCIAL", "DIRECCIÓN", "OBSERVACIÓN"};
    
    public TTienda(ArrayList<TiendaDTO> arrayList) {
       tiendas = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return tiendas.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.tiendas.get(rowIndex).getCodigo();
            case 1: return this.tiendas.get(rowIndex).getRuc();
            case 2: return this.tiendas.get(rowIndex).getRazonSocial();
            case 3: return this.tiendas.get(rowIndex).getDireccion();
            case 4: return this.tiendas.get(rowIndex).getObservacion();
            default: return this.tiendas.get(rowIndex);
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
            case 0: tiendas.get(rowIndex).setCodigo(Integer.parseInt((String) aValue)); break;
            case 1: tiendas.get(rowIndex).setRuc(String.valueOf(aValue)); break;           
            case 2: tiendas.get(rowIndex).setRazonSocial(String.valueOf(aValue)); break;
            case 3: tiendas.get(rowIndex).setDireccion(String.valueOf(aValue)); break; 
            case 4: tiendas.get(rowIndex).setObservacion(String.valueOf(aValue)); break;
        }
    }
}

