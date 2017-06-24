package com.admin.controller.tablemodel;

import com.admin.entity.dto.DetalleProveedorDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TDetalleProveedor  extends AbstractTableModel {
    private ArrayList<DetalleProveedorDTO> detalleProveedor = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class};
    private final String []titulos = {"CÓDIGO", "FECHA INICIO", "FECHA FIN"};
    
    public TDetalleProveedor(ArrayList<DetalleProveedorDTO> arrayList) {
       detalleProveedor = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return detalleProveedor.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.detalleProveedor.get(rowIndex).getCodigo();
            case 1: return this.detalleProveedor.get(rowIndex).getFechaInicio();
            case 2: return this.detalleProveedor.get(rowIndex).getFechaFin();
            default: return this.detalleProveedor.get(rowIndex);
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
            case 0: detalleProveedor.get(rowIndex).setCodigo(Integer.parseInt((String) aValue)); break;
            case 1: detalleProveedor.get(rowIndex).setFechaInicio(String.valueOf(aValue)); break;
            case 2: detalleProveedor.get(rowIndex).setFechaFin(String.valueOf(aValue)); break; 
        }
    }
}

