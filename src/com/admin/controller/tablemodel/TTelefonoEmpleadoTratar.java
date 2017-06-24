package com.admin.controller.tablemodel;

import com.admin.entity.pojo.TelefonoEmpleadoTratarP;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TTelefonoEmpleadoTratar  extends AbstractTableModel {
    private ArrayList<TelefonoEmpleadoTratarP> telefonos = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"CÓDIGO", "NOMBRES", "TELEFONIA", "TIPO", "NÚMERO", "TIPO REFERENCIA", "CODIGO REFERENCIA"};
    
    public TTelefonoEmpleadoTratar(ArrayList<TelefonoEmpleadoTratarP> arrayList) {
       telefonos = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return telefonos.size();
    }

    @Override
    public int getColumnCount() {
       return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.telefonos.get(rowIndex).getCodigo();
            case 1: return this.telefonos.get(rowIndex).getNombreApellidos();
            case 2: return this.telefonos.get(rowIndex).getTelefonia();
            case 3: return this.telefonos.get(rowIndex).getTipoTelefonia();
            case 4: return this.telefonos.get(rowIndex).getNumero();
            case 5: return this.telefonos.get(rowIndex).getTipoReferencia();
            case 6: return this.telefonos.get(rowIndex).getCodigoReferencia();
            default: return this.telefonos.get(rowIndex);
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
            case 0: telefonos.get(rowIndex).setCodigo(Integer.parseInt((String) aValue)); break;
            case 1: telefonos.get(rowIndex).setNombreApellidos(String.valueOf(aValue)); break;
            case 2: telefonos.get(rowIndex).setTelefonia(String.valueOf(aValue)); break;
            case 3: telefonos.get(rowIndex).setTipoTelefonia(String.valueOf(aValue)); break;
            case 4: telefonos.get(rowIndex).setNumero(String.valueOf(aValue)); break; 
            case 5: telefonos.get(rowIndex).setTipoReferencia(String.valueOf(aValue)); break; 
            case 6: telefonos.get(rowIndex).setCodigoReferencia(String.valueOf(aValue)); break; 
        }
    }
}

