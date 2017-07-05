package com.admin.controller.tablemodel;

import com.admin.model.pojo.ListaCrudUsuarioP;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TUsuario  extends AbstractTableModel {
    private ArrayList<ListaCrudUsuarioP> usuario = null;
    private final Class[] tiposColumn = {String.class, String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"CÓDIGO", "NOMBRE", "CUENTA USUARIO", "CARGO", "ESTADO", "IP"};
    
    public TUsuario(ArrayList<ListaCrudUsuarioP> arrayList) {
       usuario = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return usuario.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.usuario.get(rowIndex).getCodigo();
            case 1: return this.usuario.get(rowIndex).getNombreApellidos();
            case 2: return this.usuario.get(rowIndex).getCuenta();
            case 3: return this.usuario.get(rowIndex).getCargoNombre();
            case 4: return this.usuario.get(rowIndex).getEstado();
            case 5: return this.usuario.get(rowIndex).getIpReferencia();
            default: return this.usuario.get(rowIndex);
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
            case 0: usuario.get(rowIndex).setCodigo(String.valueOf(aValue)); break;
            case 1: usuario.get(rowIndex).setNombreApellidos(String.valueOf(aValue)); break;            
            case 2: usuario.get(rowIndex).setCargoNombre(String.valueOf(aValue)); break;
            case 3: usuario.get(rowIndex).setCuenta(String.valueOf(aValue)); break;
            case 4: usuario.get(rowIndex).setEstado(String.valueOf(aValue)); break;
            case 5: usuario.get(rowIndex).setIpReferencia(String.valueOf(aValue)); break;
        }
    }
}

