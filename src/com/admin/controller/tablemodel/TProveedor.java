package com.admin.controller.tablemodel;

import com.admin.entity.dto.ProveedorDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TProveedor  extends AbstractTableModel {
    private ArrayList<ProveedorDTO> proveedores = null;
    private final Class[] tiposColumn = {String.class, String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"NOMBRE", "RUC", "DIRECCION", "WEB", "EMAIL", "ESTADO"};
    
    public TProveedor(ArrayList<ProveedorDTO> arrayList) {
       proveedores = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return proveedores.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.proveedores.get(rowIndex).getNombre();
            case 1: return this.proveedores.get(rowIndex).getRuc();
            case 2: return this.proveedores.get(rowIndex).getDireccion();
            case 3: return this.proveedores.get(rowIndex).getSitioWeb();
            case 4: return this.proveedores.get(rowIndex).getEmail();
            case 5: return this.proveedores.get(rowIndex).getEstado();
            default: return this.proveedores.get(rowIndex);
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
            case 0: proveedores.get(rowIndex).setNombre(String.valueOf(aValue)); break;
            case 1: proveedores.get(rowIndex).setRuc(String.valueOf(aValue)); break;           
            case 2: proveedores.get(rowIndex).setDireccion(String.valueOf(aValue)); break;
            case 3: proveedores.get(rowIndex).setSitioWeb(String.valueOf(aValue)); break; 
            case 4: proveedores.get(rowIndex).setEmail(String.valueOf(aValue)); break;
            case 5: proveedores.get(rowIndex).setEstado(String.valueOf(aValue)); break;
        }
    }
}

