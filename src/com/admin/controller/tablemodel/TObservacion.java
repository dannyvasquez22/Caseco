package com.admin.controller.tablemodel;

import com.admin.entity.dto.ObservacionDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TObservacion  extends AbstractTableModel {
    private ArrayList<ObservacionDTO> observacion = null;
    private final Class[] tiposColumn = {String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"CÓDIGO", "FECHA", "DESCRIPCIÓN", "TIPO REFERENCIA", "REFERENCIA"};
    
    public TObservacion(ArrayList<ObservacionDTO> arrayList) {
       observacion = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return observacion.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.observacion.get(rowIndex).getCodigo();
            case 1: return this.observacion.get(rowIndex).getFecha();
            case 2: return this.observacion.get(rowIndex).getDescripcion();
            case 3: return this.observacion.get(rowIndex).getTipoReferencia();
            case 4: return this.observacion.get(rowIndex).getCodigoReferencia();
            default: return this.observacion.get(rowIndex);
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
            case 0: observacion.get(rowIndex).setCodigo(Integer.parseInt((String) aValue)); break;
            case 1: observacion.get(rowIndex).setFecha(String.valueOf(aValue)); break;
            case 2: observacion.get(rowIndex).setDescripcion(String.valueOf(aValue)); break; 
            case 3: observacion.get(rowIndex).setTipoReferencia(String.valueOf(aValue)); break;
            case 4: observacion.get(rowIndex).setCodigoReferencia(String.valueOf(aValue)); break;
        }
    }
}

