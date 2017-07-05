package com.admin.controller.tablemodel;

import com.admin.model.pojo.EmpleadoP;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TEmpleadoUsuario  extends AbstractTableModel {
    private ArrayList<EmpleadoP> empleados = null;
    private final Class[] tiposColumn = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"CÓDIGO", "DNI", "NOMBRE", "CARGO", "GÉNERO", "DIRECCIÓN", "E-MAIL", "FECHA NAC.", "ESTADO"};
    
    public TEmpleadoUsuario(ArrayList<EmpleadoP> arrayList) {
       empleados = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return empleados.size();
    }

    @Override
    public int getColumnCount() {
       return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.empleados.get(rowIndex).getCodigo();
            case 1: return this.empleados.get(rowIndex).getDni();
            case 2: return this.empleados.get(rowIndex).getNombreApellidos();                       
            case 3: return this.empleados.get(rowIndex).getCargoNombre();
            case 4: return this.empleados.get(rowIndex).getSexo();
            case 5: return this.empleados.get(rowIndex).getDireccion();
            case 6: return this.empleados.get(rowIndex).getEmail();
            case 7: return this.empleados.get(rowIndex).getFechaNacimiento();
            case 8: return this.empleados.get(rowIndex).getEstado();
            default: return this.empleados.get(rowIndex);
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
            case 0: empleados.get(rowIndex).setCodigo(String.valueOf(aValue)); break;
            case 1: empleados.get(rowIndex).setDni(String.valueOf(aValue)); break;
            case 2: empleados.get(rowIndex).setNombreApellidos(String.valueOf(aValue)); break;
            case 3: empleados.get(rowIndex).setCargoNombre(String.valueOf(aValue)); break;
            case 4: empleados.get(rowIndex).setSexo(String.valueOf(aValue)); break;            
            case 5: empleados.get(rowIndex).setDireccion(String.valueOf(aValue)); break;
            case 6: empleados.get(rowIndex).setEmail(String.valueOf(aValue)); break;
            case 7: empleados.get(rowIndex).setFechaNacimiento(String.valueOf(aValue)); break;
            case 8: empleados.get(rowIndex).setEstado(String.valueOf(aValue)); break;
        }
    }
}

