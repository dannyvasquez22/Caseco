package com.admin.controller.tablemodel;

import com.admin.entity.pojo.AccesoUsuarioP;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TAccesoUsuario  extends AbstractTableModel {
    private ArrayList<AccesoUsuarioP> accesos = null;
    private final Class[] tiposColumn = {String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"NOMBRE", "CUENTA USUARIO", "FECHA", "HORA INICIO", "HORA FIN"};
    
    public TAccesoUsuario(ArrayList<AccesoUsuarioP> arrayList) {
       accesos = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return accesos.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.accesos.get(rowIndex).getNombreApellidos();
            case 1: return this.accesos.get(rowIndex).getCuenta();
            case 2: return this.accesos.get(rowIndex).getFecha();
            case 3: return this.accesos.get(rowIndex).getHoraInicio();
            case 4: return this.accesos.get(rowIndex).getHoraFin();
            default: return this.accesos.get(rowIndex);
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
            case 0: accesos.get(rowIndex).setNombreApellidos(String.valueOf(aValue)); break;
            case 1: accesos.get(rowIndex).setCuenta(String.valueOf(aValue)); break;
            case 2: accesos.get(rowIndex).setFecha(String.valueOf(aValue)); break;
            case 3: accesos.get(rowIndex).setHoraInicio(String.valueOf(aValue)); break;
            case 4: accesos.get(rowIndex).setHoraFin(String.valueOf(aValue)); break;
        }
    }
}

