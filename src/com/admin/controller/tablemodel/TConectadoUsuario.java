package com.admin.controller.tablemodel;

import com.admin.entity.pojo.ConectadoUsuarioP;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TConectadoUsuario  extends AbstractTableModel {
    private ArrayList<ConectadoUsuarioP> conectados = null;
    private final Class[] tiposColumn = {String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"NOMBRE", "CUENTA USUARIO", "CARGO", "ESTADO", "IP"};
    
    public TConectadoUsuario(ArrayList<ConectadoUsuarioP> arrayList) {
       conectados = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return conectados.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.conectados.get(rowIndex).getNombreApellidos();
            case 1: return this.conectados.get(rowIndex).getCuenta();
            case 2: return this.conectados.get(rowIndex).getCargoNombre();
            case 3: return this.conectados.get(rowIndex).getEstado();
            case 4: return this.conectados.get(rowIndex).getIpReferencia();
            default: return this.conectados.get(rowIndex);
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
            case 0: conectados.get(rowIndex).setNombreApellidos(String.valueOf(aValue)); break;
            case 1: conectados.get(rowIndex).setCuenta(String.valueOf(aValue)); break;
            case 2: conectados.get(rowIndex).setCargoNombre(String.valueOf(aValue)); break;
            case 3: conectados.get(rowIndex).setEstado(String.valueOf(aValue)); break;
            case 4: conectados.get(rowIndex).setIpReferencia(String.valueOf(aValue)); break;
        }
    }
}

