package com.admin.controller.tablemodel;

import com.admin.model.dto.UnidadMedidaDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TUnidadMedida  extends AbstractTableModel {
    private ArrayList<UnidadMedidaDTO> unidades = null;
    private final Class[] tiposColumn = {String.class, Float.class, String.class};
    private final String []titulos = {"NOMBRE", "VALOR REFERENCIA", "DESCRIPCIÓN"};
    
    public TUnidadMedida(ArrayList<UnidadMedidaDTO> arrayList) {
       unidades = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return unidades.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.unidades.get(rowIndex).getNombre();
            case 1: return this.unidades.get(rowIndex).getValorReferencia();
            case 2: return this.unidades.get(rowIndex).getDescripcion();
            default: return this.unidades.get(rowIndex);
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
            case 0: unidades.get(rowIndex).setNombre(String.valueOf(aValue)); break;
            case 1: unidades.get(rowIndex).setValorReferencia(Float.parseFloat(String.valueOf(aValue))); break;
            case 2: unidades.get(rowIndex).setDescripcion(String.valueOf(aValue)); break;
        }
    }
}

