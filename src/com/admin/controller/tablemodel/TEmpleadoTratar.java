package com.admin.controller.tablemodel;

import com.admin.entity.dto.EmpleadoTratarDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TEmpleadoTratar  extends AbstractTableModel {
    private ArrayList<EmpleadoTratarDTO> empleadoTrato = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class};
    private final String []titulos = {"CÓDIGO", "DNI", "NOMBRES"};
    
    public TEmpleadoTratar(ArrayList<EmpleadoTratarDTO> arrayList) {
       empleadoTrato = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return empleadoTrato.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.empleadoTrato.get(rowIndex).getCodigo();
            case 1: return this.empleadoTrato.get(rowIndex).getDni();
            case 2: return this.empleadoTrato.get(rowIndex).getNombresApellidos();
            default: return this.empleadoTrato.get(rowIndex);
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
            case 0: empleadoTrato.get(rowIndex).setCodigo(Integer.parseInt(String.valueOf(aValue))); break;
            case 1: empleadoTrato.get(rowIndex).setDni(String.valueOf(aValue)); break;
            case 2: empleadoTrato.get(rowIndex).setNombresApellidos(String.valueOf(aValue)); break;
        }
    }
}

