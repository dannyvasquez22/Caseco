package com.admin.controller.tablemodel;

import com.admin.model.dto.VendedorDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TVendedor  extends AbstractTableModel {
    private ArrayList<VendedorDTO> vendedores = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class};
    private final String []titulos = {"CÓDIGO", "DNI", "NOMBRES", "CÓD. ASIGNADO"};
    
    public TVendedor(ArrayList<VendedorDTO> arrayList) {
       vendedores = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return vendedores.size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.vendedores.get(rowIndex).getCodigo();
            case 1: return this.vendedores.get(rowIndex).getDni();
            case 2: return this.vendedores.get(rowIndex).getNombreApellidos();
            case 3: return this.vendedores.get(rowIndex).getCodPro();
            default: return this.vendedores.get(rowIndex);
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
            case 0: vendedores.get(rowIndex).setCodigo(Integer.parseInt(String.valueOf(aValue))); break;
            case 1: vendedores.get(rowIndex).setDni(String.valueOf(aValue)); break;
            case 2: vendedores.get(rowIndex).setNombreApellidos(String.valueOf(aValue)); break;
            case 3: vendedores.get(rowIndex).setCodPro(String.valueOf(aValue)); break;
        }
    }
}

