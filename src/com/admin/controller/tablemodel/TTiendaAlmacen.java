package com.admin.controller.tablemodel;

import com.admin.entity.pojo.TiendaAlmacenP;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TTiendaAlmacen  extends AbstractTableModel {
    private ArrayList<TiendaAlmacenP> detalle = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class};
    private final String []titulos = {"COD", "FECHA INICIO", "FECHA FIN", "LUGAR DE VENTA"};
    
    public TTiendaAlmacen(ArrayList<TiendaAlmacenP> arrayList) {
       detalle = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return detalle.size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.detalle.get(rowIndex).getCodigo();
            case 1: return this.detalle.get(rowIndex).getFechaInicio();
            case 2: return this.detalle.get(rowIndex).getFechaFin();
            case 3: return this.detalle.get(rowIndex).getAlmacen();
            default: return this.detalle.get(rowIndex);
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
            case 0: detalle.get(rowIndex).setCodigo(Integer.parseInt(String.valueOf(aValue))); break;
            case 1: detalle.get(rowIndex).setFechaInicio(String.valueOf(aValue)); break;           
            case 2: detalle.get(rowIndex).setFechaFin(String.valueOf(aValue)); break;
            case 3: detalle.get(rowIndex).setAlmacen(String.valueOf(aValue)); break;
        }
    }
}

